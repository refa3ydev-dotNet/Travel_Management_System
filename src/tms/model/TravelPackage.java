/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

import java.util.List;
import tms.patterns.ITravelComponent;

/**
 *
 * @author 3mora
 */
public class TravelPackage implements ITravelComponent {
    private int Id ;
    private String Name;
    private String Type;
    private String destination;
    private double basePrice;
    private List<String> Activities;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setActivities(List<String> Activities) {
        this.Activities = Activities;
    }
    
    
    
    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getDestination() {
        return destination;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<String> getActivities() {
        return Activities;
    }


    @Override
    public String getDescription() {
        return Name + " - " + Type + " to " + destination;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "TravelPackage{" + "Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", destination=" + destination + ", basePrice=" + basePrice + ", Activities=" + Activities + '}';
    }
    
    
}
