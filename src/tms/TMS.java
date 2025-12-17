package tms;

import java.util.Arrays;
import java.util.Date;

import tms.manager.BookingManager;
import tms.manager.UserProfileManager;

import tms.model.*;
import tms.patterns.*;

public class TMS {

    public static void main(String[] args) {
                // الحصول على instance
        BookingManager manager = BookingManager.getInstance();
        UserProfileManager uManager = UserProfileManager.getInstance();
        
        // طباعة عدد الـ bookings المحملة
        System.out.println("Total bookings: " + manager.getBookings().size());
        
        // طباعة تفاصيل كل booking
        for (Booking b : manager.getBookings()) {
            System.out.println("Booking #" + b.getId() + 
                             " - Status: " + b.getStatus() + 
                             " - Price: " + b.getTotalPrice());
    }
        
        // إضافة users
        User user1 = new User(1, "Ahmed", "ahmed@example.com");
        User user2 = new User(2, "Mohamed", "mohamed@example.com");
        
        uManager.addUser(user1);
        uManager.addUser(user2);
        
        // إضافة points
        uManager.addPointsToUser(1, 100);
        uManager.addPointsToUser(2, 50);
        
        // محاولة إضافة points سالبة (سيفشل)
        uManager.addPointsToUser(1, -20);
        
        // طباعة كل الـ users
        System.out.println("\n📋 All Users:");
        for (User u : uManager.getUsers()) {
            System.out.println(u);
        }
        
        // خصم points
        User u1 = uManager.getUserById(1);
        if (u1 != null) {
            System.out.println("Deducting 30 points from " + u1.getName());
            u1.deductPoints(30);
            System.out.println("Remaining points: " + u1.getLoyalPoints());
        }
    }
}
