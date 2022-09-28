package video_rental.rental_store;

import video_rental.items.*;
/**
 * This class provides multiple Methods to building a customer.
 * This class creats a customer and checks his inventory for borrowd items.
 * 
 * @author Altin Nimanaj
 * @version 2022 Mai 10.
 */
public class Customer {
    /**
     * Is the  firsr name of a customer.
     * @author Altin Nimanaj.
    */
    private String firstName;
    /**
     * Is the  surename of a customer.
     * @author Altin Nimanaj.
    */
    private String lastName;
    /**
     * Is the age of the customer.
     * @author Altin Nimanaj.
     */
    private int age;
    /**
     * Is the ID of the customer.
     * @auther Altin Nimanaj.
     */
    private int customerNumber;
    /**
     * Is the DVD inventory of the customer.
     * @author Altin Nimanaj.
     */
    private DVD[] dvds;
    /**
     * Is the CD inventory of the customer.
     * @author Altin Nimanaj.
     */
    private CD[] cds;
    /**
     * Is the BlueRay inventory of the customer.
     * @author Altin Nimanaj.
     */
    private BlueRay[] brs;
    /**
     * Is the Medium inventory of the customer.
     * @author Altin Nimanaj.
     */
    private Medium[] meds;
    /**
     * Is the start point for the ID's (Kundennummern).
     * @author Altin Nimanaj.
     */
    private static int currentMaxCustomerNumber = 0;

    /**
     * Is the amount of money the customer has.
     * @author Altin Nimanaj.
     */
    private double money = 0.0;
    
    /**
     * Is the cunstructor.
     * Taks the params and stors them to there variables.
     * 
     * @author Altin Nimanaj.
     * @param vorname first name.
     * @param nachname surename.
     * @param alter age.
     */
    public Customer(String firstName, String lastName, int age, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.money = money;

        this.customerNumber = ++currentMaxCustomerNumber;
        this.dvds = new DVD[10];
        this.cds = new CD[10];
        this.brs = new BlueRay[10];
        this.meds = new Medium[10];
    }

    /**
     * Getter for the Money.
     * @author Altin Nimanaj.
     * @return  money.
     */
    public double getMoney(){
        return this.money;
    }
    /**
     * 
     * @param money
     */
    public void setMoney(double money){
        this.money = money;
    }

    /**
     * Getter for first name.
     * 
     * @author Altin Nimanaj.
     * @return first and surename.
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Getter for last name.
     * @return lastName.
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Getter for the age.
     * 
     * @author Altin Nimanaj.
     * @return age.
     */
    public int getAge() {
        return this.age;
    }
    /**
     * Getter for ID.
     * 
     * @author Altin Nimanaj.
     * @return customerNumber.
     */
    public int getCustomerNumber() {
        return this.customerNumber;
    }
    /**
     * Getter for DVD.
     * 
     * @author Altin Nimanaj.
     * @return dvds.
     */
    public DVD[] getDvds() {
        return this.dvds;
    }
    /**
     * Getter for CD.
     * 
     * @author Altin Nimanaj.
     * @return cds.
     */
    public CD[] getCds() {
        return this.cds;
    }
    /**
     * Getter for BlueRay.
     * 
     * @author Altin Nimanaj.
     * @return customerNumber.
     */
    public BlueRay[] getBlueRay() {
        return this.brs;
    }
    /**
     * Getter for Medium.
     * 
     * @author Altin Nimanaj.
     * @return customerNumber.
     */
    public Medium[] getMedium() {
        return this.meds;
    }
    /**
     * Controls the borrowing of a DVD.
     * First it is checked whether the age and the item can be borrowed. 
     *  The status of this DVD is set to borrowd and stored in the customer's inventory.
     * 
     * @author Altin Nimanaj.
     * @param dvd is a DVD stord in the array.
     */
    public void rentDVD(DVD dvd) {
        if (! dvd.ageValid(this.age) || dvd.isRented())
            System.exit(1);
        for (int i = 0; i < this.dvds.length; i++) {
            if (this.dvds[i] == null) {
                this.money -= dvd.getPrice();
                this.dvds[i] = dvd;
                dvd.rent();
                break;
            }
        }
    }
    /**
     * A DVD is returned to inventory.
     * It is checked whether the customer owns the DVD. 
     *  If the customer has the DVD then the status of the DVD is set 
     *  to borrowable and the customer loses the DVD.
     * 
     * @author Altin Nimanaj.
     * @param age is a CD stord in the array.
     */
    public void rentCD(CD cd) {
        if (! cd.ageValid(this.age) || cd.isRented())
        System.exit(1);
        for (int i = 0; i < this.cds.length; i++) {
            if (this.cds[i] == null) {
                this.money -= cd.getPrice();
                this.cds[i] = cd;
                cd.rent();
                break;
            }
        }
    }
    /**
     * A BlueRay is returned to inventory.
     * It is checked whether the customer owns the BlueRay. 
     *  If the customer has the BlueRay then the status of the BlueRay is set 
     *  to borrowable and the customer loses the BlueRay.
     * 
     * @author Altin Nimanaj.
     * @param brs is a BlueRay stord in the array.
     */
    public void rentBlueRay(BlueRay brs) {
        if (! brs.ageValid(this.age) || brs.isRented())
            System.exit(1);
        for (int i = 0; i < this.brs.length; i++) {
            if (this.brs[i] == null) {
                this.money -= brs.getPrice();
                this.brs[i] = brs;
                brs.rent();
                break;
            }
        }
    }
    /**
     * A Medium is returned to inventory.
     * It is checked whether the customer owns the Medium. 
     *  If the customer has the Medium then the status of the Medium is set 
     *  to borrowable and the customer loses the Medium.
     * 
     * @author Altin Nimanaj.
     * @param med is a Medium stord in the array.
     */
    public void rentMedium(Medium med) {
        if (! med.ageValid(this.age) || med.isRented())
            System.exit(1);
        for (int i = 0; i < this.meds.length; i++) {
            if (this.meds[i] == null) {
                this.money -= med.getPrice();
                this.meds[i] = med;
                med.rent();
                break;
            }
        }
    }
    /**
     * A DVD is returned to inventory.
     * It is checked whether the customer owns the DVD. 
     * If the customer has the DVD then the status of the DVD is set 
     * to borrowable and the customer loses the DVD.
     * 
     * @author Altin Nimanaj.
     * @param dvd is a DVD stord in the array.
     */
    public void returnDVD(DVD dvd) {
        for (int i = 0; i < this.dvds.length; i++) {
            if (this.dvds[i] != null && this.dvds[i] == dvd) {
                this.money += dvd.getPrice();
                this.dvds[i] = null;
                break;
            }
        }
    }
    /**
     * Controls the borrowing of a CD.
     * First it is checked whether the age and the item can be borrowed. 
     *  The status of this CD is set to borrowd and stored in the customer's inventory.
     * 
     * @author Altin Nimanaj.
     * @param item is a CD.
     */
    public void returnCD(CD cd) {
        for (int i = 0; i < this.cds.length; i++) {
            if (this.cds[i] != null && this.cds[i] == cd) {
                this.money -= cd.getPrice();
                this.cds[i] = null;
                break;
            }
        }
    }
    /**
     * Controls the borrowing of a BlueRay.
     * First it is checked whether the age and the item can be borrowed. 
     *  The status of this BlueRay is set to borrowd and stored in the customer's inventory.
     * 
     * @author Altin Nimanaj.
     * @param item is a BlueRay.
     */
    public void returnBlueRay(BlueRay br) {
        for (int i = 0; i < this.brs.length; i++) {
            if (this.brs[i] == br) {
                this.money += br.getPrice();
                this.brs[i] = null;
                break;
            }
        }
    }
    /**
     * Controls the borrowing of a Medium.
     * First it is checked whether the age and the item can be borrowed. 
     *  The status of this Medum is set to borrowd and stored in the customer's inventory.
     * 
     * @author Altin Nimanaj.
     * @param item is a Medium.
     */
    public void returnMedium(Medium med) {
        for (int i = 0; i < this.meds.length; i++) {
            if (this.meds[i] != null && this.meds[i] == med) {
                this.money += med.getPrice();
                this.meds[i] = null;
                break;
            }
        }
    }
    /**
     * This Method puts all items from the Customer to a String.
     * First it creats the beginn of the String. After that, the colection get 
     *  searched and put in the Sting.
     * 
     * @author Altin Nimanaj.
     */
    public String toString() {
        String result = "Customer " + this.customerNumber + ":" + this.firstName + " " + this.lastName + " (" + this.age + ")" + " rented:\n";
        for (DVD dvd : this.dvds) {
            if (dvd != null) {
                result += dvd + "\n";
            }
        }
        for (CD cd : this.cds) {
            if (cd != null) {
                result += cd + "\n";
            }
        }
        for (BlueRay brs : this.brs){
            if(brs != null){
                result += brs + "\n";
            }
        }
        for (Medium med : this.meds){
            if(med != null){
                result += med +"\n";
            }
        }
        return result;
    }
}
