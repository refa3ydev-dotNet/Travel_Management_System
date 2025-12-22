/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.manager;

import java.util.ArrayList;
import java.util.List;
import tms.model.Accommodation;

/**
 *
 * @author 3mora
 */
public class AccommodationManager {
    private static AccommodationManager instance;
    private List<Accommodation> accommodations;
    private int nextId=1;
    
    private AccommodationManager(){
        this.accommodations=new ArrayList<>();
    }
    
    public static AccommodationManager getInstance(){
        if (instance==null){
            
            instance=new AccommodationManager();
        }
        return instance;
        
    }
    public Accommodation addAccommodation(Accommodation accommodation){
        if(accommodation==null){
            System.err.println("can't add null accommodation");
            return null;
        }
        accommodation.setId(nextId++);
        
        accommodations.add(accommodation);
        
        System.out.println("Accommodation added "+accommodation.getName()+
                "(ID: "+accommodation.getId()+")");
        return accommodation;
    }
    
    public List<Accommodation> getAccommodations(){
        return new ArrayList<>(accommodations);
    }
    
    public Accommodation getAccommodationById(int id){
        for(Accommodation acc : accommodations){
            if (acc.getId()==id) {
                return acc;
            }
        }
        return null;
    }
    public boolean deleteAccommodation(int id){
        boolean removed= accommodations.removeIf(a->a.getId()==id);
        if(removed){
            System.out.println("Accommodation delete: ID "+id);
        }
        return removed;
    }
}
