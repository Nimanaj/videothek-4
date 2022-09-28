package video_rental.items;

import java.util.Random;
import video_rental.items.tags.FSKRating;
import video_rental.items.tags.MovieGenre;

/**
 * This class provides multiple Methods to borrow a DVD.
 * This class creats DVD's and reviws them by FSK rating and by genre.
 * 
 * @author Altin Nimanaj.
 * @version 2022 Mai 24.
 */
public class DVD implements MediumI{
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
     * Stors an element. 
     * @autor Altin Nimanaj.
     */
    private FSKRating rating;
    /**
     * Stors an element of MovieGenre for the Method strGenreDVD().
     * @autor Altin Nimanaj.
     */
    private MovieGenre genre;
    /**
     * Stors the ID in a string
     */
    protected String id;
    /**
     * Is the constructor.
     * Creats a DVD.
     * 
     * @autor Altin Nimanaj.
     * @param title is the title.
     * @param price is the price.
     * @param rating is the sale price.
     * @param genre is the movi genre.
     */
    public DVD(String title, double price, FSKRating rating, MovieGenre genre, String id) {
        this.type ="DVD";
        this.title = title;
        this.price = price;
        this.sale_price = 0.00;
        this.on_sale = false;

        this.rating = rating;
        this.genre = genre;

        this.rented = false;
        try {
            this.id = correctID(id);
        } catch (Exception e) {
            System.out.println("The ID of this DVD: '" + this.getTitle() + "' is wrong written");
        }
        
    }   
    /**
     * The ID is checked for correctness.
     *  The first two characters get checked if there are 'tt', 'nm', 'co', 'ev', 'ch' or 'ni'.
     *  After that the ID can only have numbers.
     * 
     * @author Altin Nimanaj.
     * @param id is the ID of the medium
     * @return valid the ID
     * @throws Exception that the ID is not valid
     */
    public String correctID(String id) throws Exception{
        char chars[] = id.toCharArray();
        char numbers[] = {'1','2','3','4','5','6','7','8','9','0'};
        int counter = 2;

        for (int i = 0; i < chars.length; i++) {
            if(chars[0] == 't' && chars[1] == 't' || chars[0] == 'n' && chars[1] == 'm' || chars[0] == 'c' && chars[1] == 'o' || chars[0] == 'e' && chars[1] == 'v' || chars[0] == 'c' && chars[1] == 'h' || chars[0] == 'n' && chars[1] == 'i'){
                for (int j = 0; j < numbers.length; j++) {
                    if(chars[i] == numbers[j]){
                        counter += 1;
                    }
                }
            }else{
                break;
            }
        }

        if(counter == chars.length){
            return id;
        }else{
            throw new Exception();
        }
    }

    /**
     * Getter for the price.
     * 
     * @author Altin Nimanaj.
     * @return price wether is sale or not.
     */
    @Override
    public double getPrice() {
        return price;
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
     * Getter for the FSK-rating.
     * 
     * @auther Altin Nimanaj.
     * @return rating.
     */
    public FSKRating getRating() {
        return this.rating;
    }
    /**
     * Getter for the genre.
     * 
     * @auther Altin Nimanaj.
     * @return genre.
     */
    public MovieGenre getGenre() {
        return this.genre;
    }
    /**
     * Returns a boolean based on the age and the Medium.
     * 
     * @auther Altin Nimanaj.
     * @return boolean.
     */
    public boolean ageValid(int age) {
        return this.rating.ageValid(age);
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
     * Creats the IMDb URL.
     * This method has a String array which is used 
     *  for making the URL random.
     * 
     * @auther Altin Nimanaj.
     * @return imb.
     */
    public String id(){
        String arr[] = {"1","2","3","4","5","6","7","8","9","0"};
        int l = arr.length;
        String imb = "tt";
        Random rad = new Random();

        for(int i = 0; i < 7; i++){
                imb += arr[rad.nextInt(l)];
        }
        return imb;
    }

}