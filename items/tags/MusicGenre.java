package video_rental.items.tags;

public enum MusicGenre {
    ROCK,
    POP,
    CLASSIC,
    JAZZ,
    BLUES,
    COUNTRY,
    REGGAE,
    HIPHOP,
    RAP,
    ELECTRONIC,
    ALTERNATIVE,
    OTHER;
    /**
     * This method returns one of the enums.
     * 
     * @author Altin Nimanaj.
     * @return the searched value.
     */
    public String str() {
        switch (this) {
            case ROCK:
                return "Rock";
            case POP:
                return "Pop";
            case CLASSIC:
                return "Classic";
            case JAZZ:
                return "Jazz";
            case BLUES:
                return "Blues";
            case COUNTRY:
                return "Country";
            case REGGAE:
                return "Reggae";
            case HIPHOP:
                return "Hip-Hop";
            case RAP:
                return "Rap";
            case ELECTRONIC:
                return "Electronic";
            case ALTERNATIVE:
                return "Alternative";
            case OTHER:
                return "Other";
            default:
                return "";
        }
    }
}
