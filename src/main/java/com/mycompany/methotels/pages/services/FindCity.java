package com.mycompany.methotels.pages.services;

import com.mycompany.methotels.dao.HotelCityDao;
import com.mycompany.methotels.entities.City;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author JOVANA
 */
public class FindCity {

    @Inject
    private Request request;
    @Property
    private List<City> cityList;
    private City city;
    @Inject
    private HotelCityDao hotelCityDao;

    Object onActivate(@RequestParameter("name") String name) {
        if (cityList == null) {
            cityList = new ArrayList<City>();
        }
        String response = "<table class=\"navigation\" > <th>\n"
                + " City name\n"
                + " </th>\n"
                + " ";
        cityList = hotelCityDao.getCityListByName(name);
        for (City d : cityList) {
            response += (" <tr>\n"
                    + " <td> " + d.getCityName() + "</td>\n"
                    + " </tr>");
        }
        response += "</table>";
        return new TextStreamResponse("text/plain", response);
    }
}
