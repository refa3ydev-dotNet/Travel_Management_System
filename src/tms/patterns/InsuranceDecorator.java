/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

/**
 *
 * @author 3mora
 */
public class InsuranceDecorator extends TravelDecorator {
    private double extraCost;
    
    public InsuranceDecorator(ITravelComponent component, double extraCost){
        super(component);
        this.extraCost=extraCost;
    
}
    @Override
    public String getDescription(){
        return component.getDescription() + " Insurance";
    }
    @Override
    public double getPrice(){
        return component.getPrice() + extraCost;
    }
}
