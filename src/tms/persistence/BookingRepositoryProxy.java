/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tms.model.Booking;

/**
 *
 * @author 3mora
 */
public class BookingRepositoryProxy implements IBookingRepository {
    private final IBookingRepository realRepository;
    private final Map<Integer, Booking> cache = new HashMap<>();

    public BookingRepositoryProxy(IBookingRepository realRepository) {
        this.realRepository = realRepository;
    }

    @Override
    public Booking getById(int id) {
        // You can add proxy logic here (e.g., logging, caching) if needed
        if (cache.containsKey(id)) {
            System.out.println("Fetching booking id " + id + " from cache.");
            return cache.get(id);
        } else {
            System.out.println("Fetching booking id " + id + " from database.");
            Booking booking = realRepository.getById(id);
            if (booking != null) {
                cache.put(id, booking);
            }
            return booking;
        }
    }

    @Override
    public void save(Booking booking) {
        System.out.println("[Proxy] save()");
        realRepository.save(booking);
        if (booking != null && booking.getId() > 0) {
            cache.put(booking.getId(), booking);
        }
    }

    @Override
    public List<Booking> getAll() {
        System.out.println("Loading all bookings from database...");
        List<Booking> bookings = realRepository.getAll();
        
        for (Booking booking : bookings) {
            if (booking != null && booking.getId() > 0) {
                cache.put(booking.getId(), booking);
            }
        }
        
        System.out.println("Cached " + bookings.size() + " bookings");
        return bookings;
    }

}
