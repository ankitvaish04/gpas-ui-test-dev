package net.autodata.nissan.qa.gpas.screenplay.utilities;

import com.jcraft.jsch.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class GetCSVRecords {

    private static String cvsHost = "";
    private static String cvsUser = "";
    private static String cvsIdentity = "";
    private static String cvsRoot = "";

    public static List<String> checkoutCsvFiles() throws JSchException, IOException, ParseException {


        // Read envInputs json file
        JSONObject envInputFile = ReadJson.getInstance().envInputFile("EnvInputs.json");
        JSONObject sqlinput = (JSONObject) envInputFile.get("cvsInput");


        cvsHost = sqlinput.get("cvsHost").toString();
        cvsUser = sqlinput.get("cvsUser").toString();
        cvsIdentity = sqlinput.get("cvsIdentity").toString();
        cvsRoot = sqlinput.get("cvsRoot").toString();


        List<String> csvFileList = new ArrayList<String>();

        // Create a SSH session to CVS Host
        JSch jsch = new JSch();
        jsch.addIdentity(cvsIdentity);
        Session cvsSession = jsch.getSession(cvsUser, cvsHost, 22);

        // Since we are using Private Identity File, set remote host key
        // checking to no
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        cvsSession.setConfig(prop);
        cvsSession.connect();

        // Run CVS Command to check out the csv files for the ymmid
        if (cvsSession.isConnected()) {
            // Open a Channel to 'Exec' commands in the remote host
            ChannelExec channelExec = (ChannelExec) cvsSession.openChannel("exec");

            // Defining charset to read the file as UTF-8
            Charset charset = Charset.forName("UTF-8");

            // Create an Input Stream to read the remote host terminal
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(channelExec.getInputStream(), charset));

            // Set and run the required checkout command for the ymmid
            channelExec.setCommand(
                    "/bin/cvs -d" + cvsRoot + " co -d" + GlobalVars.ymmId + " rosetta_edit/" + GlobalVars.ymmId + "\nls ~/" + GlobalVars.ymmId);
            channelExec.setErrStream(System.err);
            channelExec.connect();

            // Read each line from Buffer and store it to a list
            List<String> fileNames = new ArrayList<String>();
            bufferedReader.lines().forEach(files -> fileNames.add(files)

            );

            for (String f : fileNames) {
                if (f.endsWith(".csv") && !f.contains(" ")) {
                    csvFileList.add(f);
                }
            }

            // Disconnect the change
            channelExec.disconnect();
        }

        // Disconnect the Session
        cvsSession.disconnect();

        return csvFileList;
    }

    public static Map<String, List<Map<String, String>>> readCsvFileLines(List<String> cvsFilesToRead) throws JSchException {

        Map<String, List<Map<String, String>>> gpasCsvData = new HashMap<String, List<Map<String, String>>>();

        // Defining charset to read the file as UTF-8
        Charset charset = Charset.forName("UTF-8");

        // Create a SSH session to CVS Host
        JSch jsch = new JSch();
        jsch.addIdentity(cvsIdentity);
        Session cvsSession = jsch.getSession(cvsUser, cvsHost, 22);

        // Since we are using Private Identity File, set remote host key
        // checking to no
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        cvsSession.setConfig(prop);
        cvsSession.connect();

        if (cvsSession.isConnected()) {

            // Open and connect to a SFTP channel to read the csv files
            ChannelSftp sftpChannel = (ChannelSftp) cvsSession.openChannel("sftp");
            sftpChannel.connect();

            // Iterate through the file list to read csvFileLines;

            cvsFilesToRead.forEach(fileName -> {
                // Get the filename without extension to create the map
                List<String> csvFileLines = new ArrayList<String>();
                String fileNameForMap = fileName.toString().substring(0, fileName.toString().indexOf('.'));
                //System.out.println("fileformap:" + fileNameForMap);

                // Get the file from user's home directory within the respective ymmId
                InputStream remoteFile = null;
                try {
                    remoteFile = sftpChannel.get("/home/" + cvsUser + "/" + GlobalVars.ymmId + "/" + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(remoteFile, charset));

                // Read each line from the current file being processed
                bufferedReader.lines().forEach(fileLine -> csvFileLines.add(fileLine));
                // Ensure the file has 2 or more rows.
                // This is due to previous rosetta architecture where few of the
                // files are not used.
                if (csvFileLines.size() >= 2) {
                    // First, get the header row from the CSV file
                    List<String> csvHeader = new ArrayList<String>();
                    String headerLine = csvFileLines.get(0);
                    headerLine = headerLine.replaceAll("~", "\"");
                    String[] headers = headerLine.split(",");

                    for (String hdr : headers) {
                        hdr = hdr.replaceAll("\"", "");
                        csvHeader.add(hdr);
                    }

                    // System.out.println("csv Header"+csvHeader);
                    // Parse each line from the CSV file without the header row
                    List<Map<String, String>> parsedCsvLines = new ArrayList<Map<String, String>>();
                    for (String dataLine : csvFileLines.subList(1, csvFileLines.size())) {

                        // Ensure the csv row is split based on "," but not the
                        // ones with double quotes.
                        // '~' is converted to '"' so that the ',' is retained
                        // as a single column rather than multiple columns

                        dataLine = dataLine.replaceAll("~", "\"");
                        String[] dataLines = dataLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                        List<String> csvData = new ArrayList<String>();

                        for (String row : dataLines) {
                            row = row.replaceAll("\"", "");
                            csvData.add(row);
                        }

                        // There might be columns with empty value, without any
                        // double quotes or ~.
                        // To ensure the record row matches against header row,
                        // add an empty string to double quotes

                        for (int i = csvData.size(); i < csvHeader.size(); i++) {
                            csvData.add("");
                        }

                        // For each csv data row, add the columns into a map
                        // based on corresponding header column
                        Map<String, String> csvLineData = new HashMap<String, String>();
                        for (int i = 0; i < csvHeader.size(); i++) {
                            csvLineData.put(csvHeader.get(i), csvData.get(i));
                        }
                        parsedCsvLines.add(csvLineData);

                    }
                    // For each csv file lines, convert the records into a map
                    // based on filename and the parsed list of map data
                    gpasCsvData.put(fileNameForMap, parsedCsvLines);

                }
            });
        }

        // Disconnect the SSH session
        cvsSession.disconnect();

        return gpasCsvData;

    }


    // main method for testing

    public static void main(String ar[]) throws IOException, JSchException, ParseException {
      /*  List<String> cvsFileToRead = checkoutCsvFiles("27629", "192.167.99.100", "abad_centos",
                "C:\\apache-tomcat-6.0.53\\gpas\\Nissan.priv", "/home/cvsroot");

        Map<String, List<Map<String, String>>> gpasCsvData = readCsvFileLines("27629", "192.167.99.100", "abad_centos",
                "C:\\apache-tomcat-6.0.53\\gpas\\Nissan.priv", cvsFileToRead);

        System.out.println(gpasCsvData);
        System.out.println(gpasCsvData.get("equiplngdescription").get(1).get("sequence_num"));
    }*/

        Map<String, List<Map<String, String>>> gpasCvsDataInMap = null;
        List<String> modelValues = new ArrayList<String>();
//        System.out.println(gpasCsvData);
//        System.out.println("YMMID:  "+gpasCsvData.get("model").get(0).get("locale"));
        gpasCvsDataInMap = GetCSVRecords.readCsvFileLines(GetCSVRecords.checkoutCsvFiles());
        System.out.println("ModelList : " + gpasCvsDataInMap.get("model").get(0));
        gpasCvsDataInMap.get("model").get(0).forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
            modelValues.add(value);
                });
        System.out.println("Values : " + modelValues);
    }
}