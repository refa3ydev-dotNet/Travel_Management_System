/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

import tms.model.Accommodation;
import tms.model.Hostel;
import tms.model.Hotel;
import tms.model.Resort;

/**
 *
 * @author 3mora
 */
public class AccommodationFactory {
    
    
    public static Accommodation createAccommodation(String Type){
        if(Type == null){
            
        return null;
        }
        else{
            switch(Type.toLowerCase()){
                case "hotel":
                    return new Hotel();
                case "hostel":
                    return new Hostel();
                case "resort":
                    return new Resort();
                default:
                    return null;
                    
            }
        }
        
        
    }
    
    // Builder 
        public static Hotel createHotel(String name, String location, double pricePerNight, 
                                    boolean hasBreakfast) {
        return (Hotel) new AccommodationBuilder("hotel")
                .setName(name)
                .setLocation(location)
                .setPricePerNight(pricePerNight)
                .setHasBreakfast(hasBreakfast)
                .setCapacity(2)
                .setRating(4.0)
                .build();
    }
    
    public static Resort createResort(String name, String location, double pricePerNight, 
                                      boolean hasPool) {
        return (Resort) new AccommodationBuilder("resort")
                .setName(name)
                .setLocation(location)
                .setPricePerNight(pricePerNight)
                .setHasPool(hasPool)
                .setCapacity(4)
                .setRating(4.5)
                .build();
    }
    
    public static Hostel createHostel(String name, String location, double pricePerNight, 
                                      boolean sharedRoom) {
        return (Hostel) new AccommodationBuilder("hostel")
                .setName(name)
                .setLocation(location)
                .setPricePerNight(pricePerNight)
                .setSharedRoom(sharedRoom)
                .setCapacity(6)
                .setRating(3.5)
                .build();
    }

}




