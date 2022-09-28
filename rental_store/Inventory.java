package video_rental.rental_store;
import video_rental.items.*;

/**
 * This class provides multiple Methods to building an inventory.
 * This class creats a inventoty and reviws them by Explicit Label and by genre.
 * 
 * @author Altin Nimanaj.
 * @version 2022 Mai 10.
 */
public class Inventory {
    /**
     * Is an array from type DVD representing the inventory.
     * @author Altin Nimanaj.
     */
    DVD[] dvds;
    /**
     * Is an array from type CD representing the inventory.
     * @author Altin Nimanaj.
     */
    CD[] cds;
    /**
     * Is an array from type BlueRay representing the inventory.
     * @author Altin Nimanaj.
     */
    BlueRay[] brs;
    /**
     * Is an array from type Medium representing the inventory.
     * @author Altin Nimanaj.
     */
    Medium[] med;
    /**
     * This method givs the arrays there langth.
     * @author Altin Nimanaj.
     */
    public Inventory() {
        this.dvds = new DVD[10];
        this.cds = new CD[10];
        this.brs = new BlueRay[10];
        this.med = new Medium[10];
    }
    /**
     * This method add's a DVD's to the inventory.
     * Iterates over the array and searches for 
     *  null in the index of the inventory. If found, the DVD will be 
     *  saved there.
     * 
     * @author Altin Nimanaj.
     * @param item is a DVD.
     */
    public void addDVD(DVD item) {
        for (int i = 0; i < this.dvds.length; i++) {
            if (this.dvds[i] == null) {
                this.dvds[i] = item;
                break;
            }
        }
    }
    /**
     * This method add's a CD's to the inventory.
     * Iterates over the array and searches for 
     *  null in the index of the inventory. If found, the CD will be 
     *  saved there.
     * 
     * @author Altin Nimanaj.
     */
    public void addCD(CD item) {
        for (int i = 0; i < this.cds.length; i++) {
            if (this.cds[i] == null) {
                this.cds[i] = item;
                break;
            }
        }
    }
    /**
     * This method add's a BlueRay's to the inventory.
     * Iterates over the array and searches for 
     *  null in the index of the inventory. If found, the CD will be 
     *  saved there.
     * 
     * @author Altin Nimanaj.
     */
    public void addBlueRay(BlueRay item) {
        for (int i = 0; i < this.brs.length; i++) {
            if (this.brs[i] == null) {
                this.brs[i] = item;
                break;
            }
        }
    }
    /**
     * This method add's a Medium's to the inventory.
     * Iterates over the array and searches for 
     *  null in the index of the inventory. If found, the CD will be 
     *  saved there.
     * 
     * @author Altin Nimanaj.
     */
    public void addMedium(Medium item) {
        for (int i = 0; i < this.med.length; i++) {
            if (this.med[i] == null) {
                this.med[i] = item;
                break;
            }
        }
    }
    /**
     * This method takes the BlueRay from the main inventory.
     * 
     * @author Altin Nimanaj.
     * @param item
     */
    public void takeBlueRay(BlueRay item) {
        for (int i = 0; i < this.brs.length; i++){
            if(this.brs[i] == item){
                this.brs[i] = null;
                break;
            }
        }
    }
    /**
     * This method takes the DVD from the main inventory.
     * 
     * @author Altin Nimanaj.
     * @param item
     */
    public void takeDvd(DVD item) {
        for (int i = 0; i < this.dvds.length; i++){
            if(this.dvds[i] == item){
                this.dvds[i] = null;
                break;
            }
        }
    }
    /**
     * This method takes the CD from the main inventory.
     * 
     * @author Altin Nimanaj.
     * @param item
     */
    public void takeCD(CD item) {
        for (int i = 0; i < this.cds.length; i++){
            if(this.cds[i] == item){
                this.cds[i] = null;
                break;
            }
        }
    }
    /**
     * This method takes the Medium from the main inventory. (until noe not jused)
     * 
     * @author Altin Nimanaj.
     * @param item
     */
    public void takeMedium(Medium item) {
        for (int i = 0; i < this.med.length; i++){
            if(this.med[i] == item){
                this.med[i] = null;
                break;
            }
        }
    }
    /**
     * Getter for the inventory for DVD.
     * 
     * @author Altin Nimanaj.
     * @return inventarDVD.
     */
    public DVD[] getDvds() {
        return this.dvds;
    }
    /**
     * Getter for inventory for CDs.
     * 
     * @author Altin Nimanaj.
     * @return inventarCD.
     */
    public CD[] getCds() {
        return this.cds;
    }
    /**
     * Getter for inventory for BlueRay.
     * 
     * @author Altin Nimanaj.
     * @return inventarDVD.
     */
    public BlueRay[] getBlueRays() {
        return this.brs;
    }
    /**
     * Getter for inventory for Medium.
     * 
     * @author Altin Nimanaj.
     * @return inventarDVD.
     */
    public Medium[] getMedium() {
        return this.med;
    }
    /**
     * Prints the invntory.
     * Iterates over the DVD, CD, BlueRay and Medium arrays and stores everything in a string.
     * 
     * @author Altin Nimanaj.
     * @return A String full of the elements from the media.
     */
    public String toString() {
        String result = "Inventar:\n\n";
        result += "\nDVDs:\n";
        for (int i = 0; i < this.dvds.length; i++) {
            if (this.dvds[i] != null) {
                result += this.dvds[i] + "\n";
            }
        }
        result += "\nCDs:\n";
        for (int i = 0; i < this.cds.length; i++) {
            if (this.cds[i] != null) {
                result += this.cds[i] + "\n";
            }
        }
        result += "\nBlueRays:\n";
        for (int i = 0; i < this.brs.length; i++) {
            if (this.brs[i] != null) {
                result += this.brs[i] + "\n";
            }
        }
        result += "\nMedien:\n";
        for (int i = 0; i < this.med.length; i++) {
            if (this.med[i] != null) {
                result += this.med[i] + "\n";
            }
        }
        return result;
    }
}