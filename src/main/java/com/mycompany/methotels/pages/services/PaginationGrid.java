package com.mycompany.methotels.pages.services;

import com.mycompany.methotels.dao.HotelCityDao;
import com.mycompany.methotels.entities.City;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author JOVANA
 */
public class PaginationGrid {

    @Inject
    private HotelCityDao hotelCityDao;
    private int size = 20;

    Object onActivate(@RequestParameter("page") int page) {
        Class<?> act = null;
        int sizeOfAll = hotelCityDao.allActiveSizeCity();
        List<City> lista = new ArrayList<City>();
        String response = "<table class=\"navigation\" > <th>\n"
                + " Ime drzave\n"
                + " </th>\n"
                + " ";
        lista = hotelCityDao.loadActiveFromTo(page);
        for (City d : lista) {
            response += (" <tr>\n"
                    + " <td> " + d.getCityName() + "</td>\n"
                    + " </tr>");
        }
        response += "</table>";
        float ceil = (float) sizeOfAll / (float) 20;
        int totalPageSizes = (int) Math.ceil(ceil);
        response += "<ul class=\"pagination\">";
        for (int i = 1; i <= totalPageSizes; i++) {
            if (page == i) {
                response += ("<li class=\"callservice active\"><a href=\"#\">" + i + "</a></li>\n");
            } else {
                response += ("<li class=\"callservice\"><a href=\"#\">" + i + "</a></li>\n");
            }
        }
        response += "</ul>";
        return new TextStreamResponse("text/plain", response);
    }
}
