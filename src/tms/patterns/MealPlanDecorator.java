/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.patterns;

/**
 *
 * @author 3mora
 */
public class MealPlanDecorator extends TravelDecorator{
    private static double mealCost = 150;
    public MealPlanDecorator(ITravelComponent component){
        super(component);
        
    }
    
    @Override
    public String getDescription(){
        return component.getDescription() + " + Meel Plan";
    }
    
    @Override
    public double getPrice(){
        return component.getPrice()+mealCost;
    }
        public static double getMealCost() {
        return mealCost;
    }
}
