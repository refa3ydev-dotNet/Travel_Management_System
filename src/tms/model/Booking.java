/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

import java.util.Date;
import tms.patterns.ITravelComponent;

/**
 *
 * @author 3mora
 */
public class Booking {
    private int Id;
    private Date bookingDate ;
    private String status;
    private double totalPrice;
    private User user;
    private ITravelComponent component;
    private Accommodation accommodation;
    private Flight flight;

    public int getId() {
        return Id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public ITravelComponent getComponent() {
        return component;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComponent(ITravelComponent component) {
        this.component = component;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    
    public double getTotalPrice(){
        if(component!=null){
            return component.getPrice();
        }
        return totalPrice;
    }
}
