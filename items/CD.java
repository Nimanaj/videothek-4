package video_rental.items;

import java.util.Random;
import video_rental.items.tags.MusicGenre;

/**
 * This class provides multiple Methods to borrow a CD.
 * This class creats Cd's and reviws them by Explicit Label and by genre.
 * 
 * @author Altin Nimanaj.
 * @version 2022 Mai 10.
 */
public class CD implements MediumI{

    /**
     * Stors a string.
     * 
     * @autor Altin Nimanaj.
     */
    protected String title;
    /**
     * Stors a double.
     * 
     * @autor Altin Nimanaj.
     */
    protected double price = 0.00;
    /**
     * Stors a double.
     * 
     * @autor Altin Nimanaj.
     */
    protected double sale_price;
    /**
     * Stors a boolean.
     * 
     * @autor Altin Nimanaj.
     */
    protected boolean on_sale;
    /**
     * Stors a boolean.
     * 
     * @autor Altin Nimanaj.
     */
    protected boolean rented;
    /**
     * Stors a String.
     * 
     * @autor Altin Nimanaj.
     */
    private String type = "";

    /**
     * Says whether the CD has a label or not.
     * @autor Altin Nimanaj.
     */
    private boolean rating;
    /**
     * Stors an element. 
     * @autor Altin Nimanaj.
     */
    private MusicGenre genre;
        /**
     * Stors the ID in a string
     */
    protected String id;
    /**
     * Is the constructor.
     * Crats a CD
     * 
     * @author Altin Nimanaj.
     * @param musicArtist is the name from the artist.
     * @param title is the title.
     * @param price is the price.
     * @param isExplicit is the label.
     * @param genre is the music genre.
     */
    public CD(String musicArtist, String title, double price, boolean isExplicit, MusicGenre genre, String id) {

        this.type = "CD";
        this.title = musicArtist + " - " + title;
        this.price = price;
        this.sale_price = 0.00;
        this.on_sale = false;

        this.rating = isExplicit;
        this.genre = genre;

        this.rented = false;
        try {
            java.util.UUID.fromString(id);
        }catch ( Exception ex ){
            System.out.println("The ID of this CD: '" + this.getTitle() + "' is wrong written");
        };
         
    }
    /**
     * Getter for the title.
     * 
     * @author Altin Nimanaj.
     * @return title.
     */
    @Override
    public String getTitle() {
        return title;
    }
    /**
     * Getter for Type.
     * 
     * @author Altin Nimanaj.
     * @return type.
     */
    @Override
    public String getType() {
        return type;
    }
    /**
     * Setter for price.
     * 
     * @author Altin Nimanaj.
     * @param price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Setter for title.
     * 
     * @author Altin Nimanaj.
     * @param title title of the Medium.
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Setter for sale price.
     * This method set the on_sale on true and set the sale_price.
     * 
     * @author Altin Nimanaj.
     * @param sale_price
     */
    @Override
    public void setSalePrice(double sale_price) {
        this.sale_price = sale_price;
    }
    /**
     * Remover for sale price.
     * 
     * @author Altin Nimanaj.
     */
    @Override
    public void removeSalePrice() {
        this.sale_price = 0.0;
        this.on_sale = false;
    }
    /**
     * This method givs the ranted back.
     * 
     * @author Altin Nimanaj.
     * @return rented.
     */
    @Override
    public boolean isRented() {
        return this.rented;
    }
    /**
     * Set ranted on true.
     * 
     * @author Altin Nimanaj.
     */
    @Override
    public void rent() {
        this.rented = true;
    }
    /**
     * Set rented on false.
     * 
     * @author Altin Nimanaj.
     */
    @Override
    public void ret() {
        this.rented = false;
    }
    /**
     * Getter for price.
     * This method asks for the offer and decides back on the price.
     * 
     * @autor Altin Nimanaj.
     * @return the price.
     */
    public double getPrice() {
        if (this.on_sale) {
            return this.sale_price;
        } else {
            return this.price;
        }
    }
    /**
     * Checks by bool.
     * Checks the bool for true or false.
     * 
     * @autor Altin Nimanaj.
     * @return true if bool is true otherwise false.
     */
    public boolean isExplicit() {
        return this.rating;
    }
    /**
     * Getter for the genre.
     * 
     * @author Altin Nimanaj
     * @return
     */
    public MusicGenre getGenre() {
        return this.genre;
    }
    /**
     * Returns true or false based on age.
     * 
     * @author Altin niamanaj
     * @return a boolean.
     */
    public boolean ageValid(int age) {
        if (this.rating) {
            return age >= 18;
        } else {
            return true;
        }
    }
    /**
     * This method creats a format string for Medium.
     * 
     * @author Altin Nimanaj.
     */
    public String toString() {
        return String.format("[%s: %s, %f EUR]", getType(), getTitle(), getPrice());
    }
    /**
     * Creats the IMDb ID.
     * This method has a String array wich creats the ID random.
     * 
     * @author Altin Nimanaj.
     * @return mbi.
     */
    public String id(){
        String arr[] = {"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String mbi = "";
        int l = arr.length;

        Random rad = new Random();

        for(int i = 0; i < 36; i++){
            if(i == 8 || i == 13 || i == 18 || i == 23){
                mbi += "-";
            } else {
                mbi += arr[rad.nextInt(l)];
            }
        }
        return mbi;
    }
}