/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

import tms.model.Accommodation;

/**
 *
 * @author 3mora
 */
public class AccomodationAdapter implements ITravelComponent{
    private Accommodation accommodation;
    private int numberOfNights;
    
    public AccomodationAdapter(Accommodation accommodation , int numberOfNights){
        if (accommodation==null){
            throw new IllegalArgumentException("Accommodation can't be null");
        }
        if (numberOfNights<=0){
            throw new IllegalArgumentException("Number of night must be positive bro");
        }
        this.accommodation=accommodation;
        this.numberOfNights=numberOfNights;
    }

    @Override
    public String getDescription() {
        return accommodation.getName() + 
               " (" + accommodation.getLocation() + ") - " + 
               numberOfNights + " night" + (numberOfNights > 1 ? "s" : "");    }

    @Override
    public double getPrice() {
        return accommodation.getPricePerNight() * numberOfNights;
    }
    
    public Accommodation getAccommodation(){
        return accommodation;
    }
    public int getNumberOfNights(){
        return numberOfNights;
    }
}
