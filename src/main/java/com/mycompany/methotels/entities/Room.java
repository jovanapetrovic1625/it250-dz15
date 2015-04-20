package com.mycompany.methotels.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/** Ovo je entitet Room koji se koristi za IT250-DZ06. */

@Entity
@Table(name = "room")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")})
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Validate("required,minlength=6")
    @Column(name = "roomName")
    private String roomName;
    @Basic(optional = false)
    @Validate("required")
    @Column(name = "floor")
    private int floor;
    @Basic(optional = false)
    @Column(name = "hasTv")
    private boolean hasTv;
    @Basic(optional = false)
    @Column(name = "hasInternet")
    private boolean hasInternet;
    @Basic(optional = false)
    @Column(name = "hasHotTub")
    private boolean hasHotTub;
    
    @Inject
    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Room(Integer id, String roomName, int floor, boolean hasTv, boolean hasInternet, boolean hasHotTub) {
        this.id = id;
        this.roomName = roomName;
        this.floor = floor;
        this.hasTv = hasTv;
        this.hasInternet = hasInternet;
        this.hasHotTub = hasHotTub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean getHasTv() {
        return hasTv;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    public boolean getHasInternet() {
        return hasInternet;
    }

    public void setHasInternet(boolean hasInternet) {
        this.hasInternet = hasInternet;
    }

    public boolean getHasHotTub() {
        return hasHotTub;
    }

    public void setHasHotTub(boolean hasHotTub) {
        this.hasHotTub = hasHotTub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Room[ id=" + id + " ]";
    }
    
}
