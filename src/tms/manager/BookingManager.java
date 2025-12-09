/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.manager;
import java.util.ArrayList;
import java.util.List;

import tms.model.Booking;

/**
 *
 * @author 3mora
 */
public class BookingManager {
    private static BookingManager Instance;
    private List<Booking> booking;
    
    private BookingManager(){
        this.booking=new ArrayList<>();
    }
    public static BookingManager getInstance(){
        if(Instance == null){
            Instance=new BookingManager();
        }
        return Instance;
    }
    public Booking createBooking(Booking b){
        if (b == null){
            return null;
        }
        booking.add(b);
        return b;
    }
    public List<Booking> getBookings(){
        return booking;
    }
}
