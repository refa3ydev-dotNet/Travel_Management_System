/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

/**
 *
 * @author 3mora
 */
public class GuideDecorator extends TravelDecorator{
    private static double guideCost=150;

    public GuideDecorator(ITravelComponent component ) {
        super(component);
        
    }
    
        
    @Override
    public String getDescription(){
        return component.getDescription() + " + Tour Guide";
    }
    
    @Override
    public double getPrice(){
        return component.getPrice() + guideCost;
    }

    public static double getGuideCost() {
        return guideCost;
    }
    
}
