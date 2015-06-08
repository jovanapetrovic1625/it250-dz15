package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.HotelCityDao;
import com.mycompany.methotels.entities.City;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

/**
 *
 * @author JOVANA
 */
public class AddCityJQuery {

    @Property
    @Persist
    private City city;
    @Property
    private City selectedcity;
    @Inject
    private HotelCityDao hotelCityDao;
    @Property
    private List<City> cityList;

    void onActivate() {
        if (cityList == null) {
            cityList = new ArrayList<City>();
        }
        cityList = hotelCityDao.getAllCitiesList();
    }

    @CommitAfter
    Object onSuccess() {
        hotelCityDao.addOrUpdateCity(city);
        city = new City();
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        hotelCityDao.deleteCity(id);
        return this;
    }

    @CommitAfter
    Object onActionFromEdit(City city) {
        this.city = city;
        return this;
    }

    public JSONObject getOptions() {
        JSONObject json = new JSONObject();
        json.put("bJQueryUI", "true");
        json.put("bStateSave", true);
        json.put("bAutoWidth", true);
        return json;
    }
}
