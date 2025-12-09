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
public class TravelPackageFactory {
    public static TravelPackage createPackage(String type, String destination, double basePrice){
        String Name=type +" package";
        return new TravelPackageBuilder()
                .setName(Name)
                .setType(type)
                .setDestination(destination)
                .setPrice(basePrice)
                .Build();
        
    }
}
