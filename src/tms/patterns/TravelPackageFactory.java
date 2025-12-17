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
    public static TravelPackage createPackage(String type, String destination, double basePrice) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }
        if (basePrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        String Name = type + " package";
        return new TravelPackageBuilder()
                .setName(Name)
                .setType(type)
                .setDestination(destination)
                .setPrice(basePrice)
                .Build();

    }
}
