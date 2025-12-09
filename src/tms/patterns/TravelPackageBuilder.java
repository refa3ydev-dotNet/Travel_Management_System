/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

import tms.model.TravelPackage;

/**
 *
 * @author 3mora
 */
public class TravelPackageBuilder {
    private TravelPackage travelPackage;
    public TravelPackageBuilder(){
        this.travelPackage=new TravelPackage();
    }
    public TravelPackageBuilder setName(String name){
        travelPackage.setName(name);
        return this;
        
    }
    public TravelPackageBuilder setType(String type){
        travelPackage.setType(type);
        return this;
        
    }
    public TravelPackageBuilder setDestination(String destination){
        travelPackage.setDestination(destination);
        return this;
    }
    public TravelPackageBuilder setPrice(double price){
        travelPackage.setBasePrice(price);
        return this;
        
    }
    public TravelPackage Build(){
        
        return travelPackage;
        
    }
}
