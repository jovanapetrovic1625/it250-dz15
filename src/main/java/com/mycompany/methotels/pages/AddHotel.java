package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.HotelCityDao;
import com.mycompany.methotels.entities.City;
import com.mycompany.methotels.entities.Hotel;
import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

@RequiresRoles("Admin")
public class AddHotel {

    @Property
    private Hotel hotel;
    @Property
    private Hotel selectedhotel;
    @Inject
    private HotelCityDao hotelDao;
    @Property
    private City cityId;
    @Property
    @Persist
    private List<City> cityList;

    public ValueEncoder getEncoder() {
        return new ValueEncoder<City>() {
            @Override
            public String toClient(City v) {
                return String.valueOf(v.getId());
            }

            @Override
            public City toValue(String string) {
                City ct = hotelDao.getCityById(Integer.parseInt(string));
                return ct;
            }
        };
    }
    @Property
    private List<Hotel> hotelList;

    void onActivate() {
        hotel = new Hotel();
        if (hotelList == null) {
            hotelList = new ArrayList<Hotel>();
        }
        hotelList = hotelDao.getAllHotelsList();
        cityList = hotelDao.getAllCitiesList();
    }

    @CommitAfter
    Object onSuccess() {
        hotel.setCityId(cityId);
        hotelDao.addHotel(hotel);
        return this;
    }

    public String getCity() {
        if (selectedhotel.getCityId() != null) {
            return selectedhotel.getCityId().getCityName();
        } else {
            return "";
        }
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        hotelDao.deleteHotel(id);
        return this;
    }
}
