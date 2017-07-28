package examples;

public class EnumExample {

    public enum BootCampDays{
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays){
        switch (bootCampDays){
            case DAYONE:
                return "Zin in!";
            case DAYTWO:
                return "Spijt van!";
            case DAYTHREE:
                return "Wat is me dit allemaal!";
            case DAYFOUR:
                return "Terug zin in!";
            case DAYFIVE:
                return "Het is de laatste dag!";
            default:
                return "Welke dag bedoel je?";
        }
    }
}
