package net.autodata.nissan.qa.gpas.screenplay.utilities;








import org.jcodings.util.Hash;
import org.json.simple.JSONObject;;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.yecht.Data;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReadSQLRows {
    public Map<String,String> readTableRows(String tableName, String queryField, String queryValue) throws SQLException, IOException, ParseException {

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Read envInputs json file
        JSONObject envInputFile=envInputFile("EnvInputs.json");
        JSONObject sqlinput = (JSONObject) envInputFile.get("sqlInput");


         String database=sqlinput.get("database").toString();
         String user=sqlinput.get("sqlUser").toString();
         String pass=sqlinput.get("sqlPass").toString();
         String url=sqlinput.get("sqlUrl").toString();

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://"+url+";" + "databaseName="+database+";user="+user+";password="+pass+"";



        try {

            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns a
            // set of data and then display it.
            String SQL = "SELECT * FROM "+tableName+" WHERE "+ queryField + " = '"+ queryValue +"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            return buildRow(rs);

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }
        return buildRow(rs);
}

    private Map<String,String> buildRow(ResultSet rs) throws SQLException {
         Map<String, String> rowData=null;
        int columnSize ;
        try {

            rowData=new HashMap<String,String>();
            columnSize = rs.getMetaData().getColumnCount();
            rs.next();
            for (int i = 1; i<=columnSize; i++) {
                rowData.put(rs.getMetaData().getColumnName(i), rs.getString(i));
            }

            System.out.println(rowData);
        }

        catch(Exception e)
        {
          e.printStackTrace();
        }

        return rowData;
    }


    private JSONObject envInputFile(String envInputFile) throws IOException, ParseException {
        //Get file from resources folder
        JSONObject jsonObject=null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL url=classLoader.getResource(envInputFile);
            FileReader file = new FileReader(classLoader.getResource(envInputFile).getPath());
            JSONParser envInputs = new JSONParser();
             jsonObject=(JSONObject) envInputs.parse(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonObject;

    }



    public static void main(String[] ar) throws SQLException, IOException, ParseException {
        new ReadSQLRows().readTableRows("YearMakeModel","YmmID","27497");
    }

    }

