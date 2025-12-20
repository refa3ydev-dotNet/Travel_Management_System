/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

/**
 *
 * @author 3mora
 */
public class TransportDecorator extends TravelDecorator{
    private static double transportCost=150;
    public TransportDecorator(ITravelComponent component){
        super(component);
        
    }
    
    @Override
    public String getDescription(){
        return component.getDescription()+ "Airport Transfer";
    }
    @Override
    public double getPrice(){
        return component.getPrice()+transportCost;
    }
        public static double getTransportCost() {
        return transportCost;
    }
}

