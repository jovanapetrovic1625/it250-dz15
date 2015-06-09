package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.City;
import com.mycompany.methotels.entities.Hotel;
import java.util.List;

public interface HotelCityDao {

    public List<City> getAllCitiesList();

    public City getCityById(Integer id);

    public void addCity(City drzava);

    public void deleteCity(Integer id);

    public List<Hotel> getAllHotelsList();

    public Hotel getHotelById(Integer id);

    public void addHotel(Hotel hotel);

    public void deleteHotel(Integer id);

    public void addOrUpdateCity(City city);

    public List<City> getCityListByName(String name);

    public abstract int allActiveSizeCity();

    public abstract List<City> loadActiveFromTo(int from);

}
