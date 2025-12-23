/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

/**
 *
 * @author 3mora
 */
public class User {
    private int Id;
    private String name;
    private String email;
    private int loyalPoints;

    public User() {
        this.loyalPoints = 0;
    }

    public User(int Id, String name, String email) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.loyalPoints = 0;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setLoyalPoints(int loyalPoints) {
        if (loyalPoints < 0) {
            System.out.println("Loyal points cannot be negative.");
            return;
        }
        this.loyalPoints = loyalPoints;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyalPoints() {
        return loyalPoints;
    }

    public void addPoints(int points) {
        if (points < 0) {
            System.out.println("Points to add cannot be negative.");
            return;
        }
        this.loyalPoints += points;
    }

    public boolean deductPoints(int points) {
        if (points < 0) {
            System.out.println("Points to deduct cannot be negative.");
            return false;
        }
        if (this.loyalPoints < points) {
            System.out.println("Insufficient loyal points.");
            return false;
        }
        this.loyalPoints -= points;
        return true;
    }

    @Override
    public String toString() {
        return getName();
    }
}
