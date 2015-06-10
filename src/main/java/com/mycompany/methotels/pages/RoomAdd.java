package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Room;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/** Ovo je strana RoomAdd koja se koristi za IT250-DZ06. */

@ProtectedPage
@RolesAllowed(value={"Admin,Korisnik"})
public class RoomAdd {

    @Property
    private Room room;
    @Inject
    private Session session;
    @Property
    private ArrayList<Room> roomList;

    void onActivate() {
        if (roomList == null) {
            roomList = new ArrayList<Room>();
        }
        // createCriteria metoda pravi Select * upit nad prosledjenom klasom
        roomList = (ArrayList<Room>) session.createCriteria(Room.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        // persist metoda cuva objekat u bazi podataka
        session.persist(room);
        return this;
    }
}
