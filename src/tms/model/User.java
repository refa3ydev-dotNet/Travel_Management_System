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

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setLoyalPoints(int LoyalPoints) {
        this.loyalPoints = LoyalPoints;
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
    
    
    
    public void AddPoints(int points){
        this.loyalPoints+=points;
    }
}
