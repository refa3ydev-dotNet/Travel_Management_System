/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

/**
 *
 * @author 3mora
 */
public class Flight {
    private int Id ;
    private String flightNumber;
    private String airLine;
    private String origin ;
    private String destination;
    private double price;
    
    public int getId() {
        return Id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirLine() {
        return airLine;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}
