/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tms.persistence;

import java.util.List;
import tms.model.Booking;

/**
 *
 * @author 3mora
 */
public interface IBookingRepository {
    Booking getById(int id);
    void save(Booking booking);
    List<Booking> getAll();
}
