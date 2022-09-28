package video_rental.items;

public interface MediumI {

    public String getTitle();

    public double getPrice();
    
    public String getType();

    public void setTitle(String title);

    public void setPrice(double price);
    
    public void setSalePrice(double sale_price);

    public boolean isRented();

    public void rent();

    public void ret();

    public void removeSalePrice();

    public boolean ageValid(int age);

    public String id();

}