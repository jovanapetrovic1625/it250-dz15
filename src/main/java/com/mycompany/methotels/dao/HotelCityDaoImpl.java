package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.City;
import com.mycompany.methotels.entities.Hotel;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HotelCityDaoImpl implements HotelCityDao {

    @Inject
    private Session session;

    @Override
    public List<City> getAllCitiesList() {
        return session.createCriteria(City.class).list();
    }

    @Override
    public City getCityById(Integer id) {
        System.out.println("Integer je " + id);
        return (City) session.createCriteria(City.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void addCity(City city) {
        session.persist(city);
    }

    @Override
    public void deleteCity(Integer id) {
        City cities = (City) session.createCriteria(City.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(cities);
    }

    @Override
    public List<Hotel> getAllHotelsList() {
        return session.createCriteria(Hotel.class).list();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return (Hotel) session.createCriteria(Hotel.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void addHotel(Hotel hotel) {
        session.persist(hotel);
    }

    @Override
    public void deleteHotel(Integer id) {
        Hotel hotel = (Hotel) session.createCriteria(Hotel.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(hotel);
    }

    @Override
    public void addOrUpdateCity(City city) {
        session.merge(city);
    }

    @Override
    public List<City> getCityListByName(String name) {
        return session.createCriteria(City.class).add(Restrictions.ilike("cityName", name + "%")).list();
    }

    @Override
    public int allActiveSizeCity() {
        Long l = (Long) session.createCriteria(City.class).setProjection(Projections.rowCount()).uniqueResult();
        return l.intValue();
    }

    @Override
    public List<City> loadActiveFromTo(int from) {
        int page = (from - 1) * 20;
        List<City> lista
                = session.createCriteria(City.class).setFirstResult(page).setMaxResults(20).addOrder(Order.asc("id")).setResultTransformer(
                        Criteria.DISTINCT_ROOT_ENTITY).list();
        return lista;
    }

}
