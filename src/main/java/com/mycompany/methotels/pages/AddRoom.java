package com.mycompany.methotels.pages;

import com.mycompany.methotels.data.Room05;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

/** Ovo je strana AddRoom koja se koristi za IT250-DZ05. */

public class AddRoom {

    @Persist
    @Property
    private ArrayList<Room05> roomList;
    @Property
    private Room05 room;

    void onActivate() {
        if (roomList == null) {
            roomList = new ArrayList<Room05>();
        }
    }

    Object onSuccess() {
        roomList.add(room);
        return this;
    }

}
