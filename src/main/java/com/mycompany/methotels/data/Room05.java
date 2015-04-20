package com.mycompany.methotels.data;

import org.apache.tapestry5.ioc.annotations.Inject;

/** Ovo je klasa Room koja se koristi za IT250-DZ05. */

public class Room05 {

    private String roomName;
    private int floor;
    private boolean hasTv;
    private boolean hasInternet;
    private boolean hasHotTub;

    @Inject
    public Room05() {
        
    }

    public Room05(String name, int floor, boolean tv, boolean internet,
            boolean hotTub) {
        this.roomName = name;
        this.floor = floor;
        this.hasTv = tv;
        this.hasInternet = internet;
        this.hasHotTub = hotTub;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isHasTv() {
        return hasTv;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    public boolean isHasInternet() {
        return hasInternet;
    }

    public void setHasInternet(boolean hasInternet) {
        this.hasInternet = hasInternet;
    }

    public boolean isHasHotTub() {
        return hasHotTub;
    }

    public void setHasHotTub(boolean hasHotTub) {
        this.hasHotTub = hasHotTub;
    }
    
    
}
