package video_rental.buying;

import video_rental.items.*;
import video_rental.items.tags.*;
import video_rental.rental_store.*;
import java.util.Scanner;

/**
 * This class interacts with the user.
 * 
 * @author Altin Nimanaj.
 * @version 2022 Mai 24.
 */
public class Buying{
    /**
     * The media gets added. The customer gets asked if he likes to borrow or to return.
     *  When he wants to borrow then he gets asked for the title of the media. 
     *  If the media is available it will be added in his inventory and will be deleted from
     *  the main inventory. He also has to pay for it.
     *  If he wants to return it then he gets asked for the title of the media aswell.
     *  If the media is in his inventory it will be added to the main inventory
     *  and that media in his inventory gets deleted and in return he gets his money back.
     *  
     *  If we want that the customer doesnt gets his money back, we have to change the 
     *  returnBlueRay, returnDVD and returnCD method.
     * 
     * @author Altin Nimanaj.
     */
    public void buying(){
        Inventory inventory = new Inventory();
        Customer customer = new Customer("Altin", "Nimanaj", 18, 200);
        Scanner scan = new Scanner(System.in);

        inventory.addMedium(new Medium("Buch", "Percy Jackson", 10, "tt0361748"));
        inventory.addBlueRay(new BlueRay("LEGEND", 3.45, "tt0361748"));
        inventory.addCD(new CD("Radiohead","OK Computer", 1.49, false, MusicGenre.ALTERNATIVE, "b1392450-e666-3926-a536-22c65f834433"));
        inventory.addCD(new CD("Radiohead","Moon Shaped Pool", 1.49, false, MusicGenre.ALTERNATIVE, "bbce#087-d386-4246-a51d-dbcdfdbe8fb2"));
        inventory.addDVD(new DVD("Inglorious Basterds", 2.99, FSKRating.FSK18, MovieGenre.ACTION, "tt0165487"));
        inventory.addDVD(new DVD("Spiderman 1", 2.99, FSKRating.FSK12, MovieGenre.ACTION, "tt0145487"));
        inventory.addDVD(new DVD("IRON MEN 3", 5.99, FSKRating.FSK12, MovieGenre.ACTION, "tt01s5487"));

        while(true){
            System.out.println("_____________\n\n");
            System.out.println(customer);
            System.out.println(customer.getMoney());
            System.out.println("_____________\n\n");
            System.out.println(inventory.toString());
            System.out.println("Moechten Sie ausleihen (1) oder zurueckgeben (2)");
            String input = scan.nextLine();

            if(input.equals("1")){
                System.out.println("Schreiben Sie den Typ vom Medium.");
                String a = scan.nextLine();

                if(a.equals("BlueRay")){
                    System.out.println("Schreiben Sie den Titel vom der BlueRay.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(inventory.getBlueRays()[j] != null){
                            if(inventory.getBlueRays()[j].getTitle().equals(b)){
                                customer.rentBlueRay(inventory.getBlueRays()[j]);
                                inventory.takeBlueRay(inventory.getBlueRays()[j]);
                            }
                        }
                    }
                }
                
                if(a.equals("DVD")){
                    System.out.println("Schreiben Sie den Titel vom der DVD.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(inventory.getDvds()[j] != null){
                            if(inventory.getDvds()[j].getTitle().equals(b)){
                                customer.rentDVD(inventory.getDvds()[j]);
                                inventory.takeDvd(inventory.getDvds()[j]);
                            }
                        }
                    }
                }
                
                if(a.equals("CD")){
                    System.out.println("Schreiben Sie den Titel vom der CD.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(inventory.getCds()[j] != null){
                            if(inventory.getCds()[j].getTitle().equals(b)){
                                customer.rentCD(inventory.getCds()[j]);
                                inventory.takeCD(inventory.getCds()[j]);
                            }
                        }
                    }
                }
                
                if(a.equals("Medium")){
                    System.out.println("Schreiben Sie den Titel vom des Mediums.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(inventory.getMedium()[j] != null){
                            if(inventory.getMedium()[j].getTitle().equals(b)){
                                customer.rentMedium(inventory.getMedium()[j]);
                                inventory.takeMedium(inventory.getMedium()[j]);
                            }
                        }
                    }
                }
                
            }
            //FALL des zurückgebens.
            //
            //
            else if(input.equals("2")){
                System.out.println("Schreiben Sie den Typ vom Medium, das Sie zurueckgeben moechten.");
                String a = scan.nextLine();

                if(a.equals("BlueRay")){
                    System.out.println("Schreiben Sie den Titel vom der BlueRay.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(customer.getBlueRay()[j] != null){
                            if(customer.getBlueRay()[j].getTitle().equals(b)){
                                inventory.addBlueRay(customer.getBlueRay()[j]);
                                customer.returnBlueRay(customer.getBlueRay()[j]);
                                
                            }
                        }
                    }
                }
                
                if(a.equals("DVD")){
                    System.out.println("Schreiben Sie den Titel vom der DVD.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(customer.getDvds()[j] != null){
                            if(customer.getDvds()[j].getTitle().equals(b)){
                                inventory.addDVD(customer.getDvds()[j]);
                                customer.returnDVD(customer.getDvds()[j]);
                                
                            }
                        }
                    }
                }
                
                if(a.equals("CD")){
                    System.out.println("Schreiben Sie den Titel vom der CD.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(customer.getCds()[j] != null){
                            if(customer.getCds()[j].getTitle().equals(b)){
                                inventory.addCD(customer.getCds()[j]);
                                customer.returnCD(customer.getCds()[j]);
                                
                            }
                        }
                    }
                }
                
                if(a.equals("Medium")){
                    System.out.println("Schreiben Sie den Titel vom des Mediums.");
                    String b = scan.nextLine();
                    for(int j = 0; j < 10; j++){
                        if(customer.getMedium()[j] != null){
                            if(customer.getMedium()[j].getTitle().equals(b)){
                                inventory.addMedium(customer.getMedium()[j]);
                                customer.returnMedium(customer.getMedium()[j]);
                                
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("Du hast was eingegeben was wir nicht verarbeiten koennen.");
                System.out.println("Moechtest du beenden ja (1), nein (2)");
                String c = scan.nextLine();
                if(c.equals("ja")){
                    break;
                }else if(c.equals("nein")){
                    System.out.println("Gut.");
                }else{
                    
                }

            }
            
        }
        scan.close();
    }
}