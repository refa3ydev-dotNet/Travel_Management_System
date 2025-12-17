/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

/**
 *
 * @author 3mora
 */
public abstract class Accommodation {
    private int Id;
    private String name;
    private String location;
    private double pricePerNight;
    private int capacity;
    private double rating;
    

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Accommodation{" + "Id=" + Id + ", name=" + name + ", location=" + location + ", pricePerNight=" + pricePerNight + ", capacity=" + capacity + ", rating=" + rating + '}';
    }
}
