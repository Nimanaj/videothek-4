package video_rental.items.tags;

public enum FSKRating {
    FSK0,
    FSK6,
    FSK12,
    FSK16,
    FSK18;

    public String str() {
        switch (this) {
            case FSK0:
                return "[FSK 0]";
            case FSK6:
                return "[FSK 6]";
            case FSK12:
                return "[FSK 12]";
            case FSK16:
                return "[FSK 16]";
            case FSK18:
                return "[FSK 18]";
            default:
                return "";
        }
    }
    /**
     * 
     * @author Altin Nimanaj.
     * @param age compares the given age with ages that are FSK-rating.
     * @return the valid age.
     */
    public boolean ageValid(int age) {
        switch (this) {
            case FSK0:
                return true;
            case FSK6:
                return age >= 6;
            case FSK12:
                return age >= 12;
            case FSK16:
                return age >= 16;
            case FSK18:
                return age >= 18;
            default:
                return false;
        }
    }
}
