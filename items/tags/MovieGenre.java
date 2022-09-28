package video_rental.items.tags;

public enum MovieGenre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    ANIMATION("Animation"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FANTASY("Fantasy"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science Fiction"),
    TV_MOVIE("TV Movie"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");
    /**
     * This variabel savs the value.
     * 
     * @author Altin Nimanaj.
     */
    private final String label;
    /**
     * Set the variabel on the given label.
     * 
     * @param label
     */
    private MovieGenre(String label) {
        this.label = label;
    }
    /**
     * This method retuns one of the enums.
     * 
     * @author Altin Nimanaj.
     * @return label.
     */
    public String str() {
        return this.label;
    }
}
