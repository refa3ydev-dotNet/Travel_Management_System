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
public class AccommodationBuilder {
    private Accommodation accommodation;
    
    public AccommodationBuilder(String Type){
        this.accommodation=AccommodationFactory.createAccommodation(Type);
        if(this.accommodation==null){
            throw new IllegalArgumentException("Inavalid accommodation type " + Type);
        }
    }
    public AccommodationBuilder setId(int id){
        accommodation.setId(id);
        return this;
    }
        public AccommodationBuilder setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        accommodation.setName(name);
        return this;
    }
    
    public AccommodationBuilder setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        accommodation.setLocation(location);
        return this;
    }
    
    public AccommodationBuilder setPricePerNight(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        accommodation.setPricePerNight(price);
        return this;
    }
    
    public AccommodationBuilder setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        accommodation.setCapacity(capacity);
        return this;
    }
    
    public AccommodationBuilder setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        accommodation.setRating(rating);
        return this;
    }
    
    // ✅ خصائص إضافية حسب النوع
    public AccommodationBuilder setHasBreakfast(boolean hasBreakfast) {
        if (accommodation instanceof Hotel) {
            ((Hotel) accommodation).setHasBreakFast(hasBreakfast);
        }
        return this;
    }
    
    public AccommodationBuilder setHasPool(boolean hasPool) {
        if (accommodation instanceof Resort) {
            ((Resort) accommodation).setHasPool(hasPool);
        }
        return this;
    }
    
    public AccommodationBuilder setSharedRoom(boolean sharedRoom) {
        if (accommodation instanceof Hostel) {
            ((Hostel) accommodation).setSharedRoom(sharedRoom);
        }
        return this;
    }
    
    public Accommodation build() {
        if (accommodation.getName() == null || accommodation.getName().isEmpty()) {
            throw new IllegalStateException("Name is required");
        }
        if (accommodation.getLocation() == null || accommodation.getLocation().isEmpty()) {
            throw new IllegalStateException("Location is required");
        }
        if (accommodation.getPricePerNight() <= 0) {
            throw new IllegalStateException("Price must be greater than zero");
        }
        
        return accommodation;
    } 
    
}
