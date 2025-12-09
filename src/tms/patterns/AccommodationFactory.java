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
}




