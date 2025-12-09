/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.model;

import tms.model.Accommodation;

/**
 *
 * @author 3mora
 */
public class Hostel extends Accommodation{
    private boolean sharedRoom;

    public boolean isSharedRoom() {
        return sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }
    
    
}
