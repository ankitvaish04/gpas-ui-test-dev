package net.autodata.nissan.qa.gpas.screenplay.mappers;

public class SubdivisionMapper {

    public enum subdivisionMapper {
        NISSAN_CARS {
            @Override
            public String toString() {
                return "1";
            }
        },
        INFINITI_CARS {
            @Override
            public String toString() {
                return "2";
            }
        },
        NISSAN_SPORT_UTILITY {
            @Override
            public String toString() {
                return "4";
            }
        },
        NISSAN_TRUCKS_VAN {
            @Override
            public String toString() {
                return "5";
            }
        },
        INFINITI_SPORT_UTILITY {
            @Override
            public String toString() {
                return "6";
            }
        }
    }

}
