package ua.univer.finTask.BLL;

import ua.univer.finTask.DAL.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    DataProvider provider;

    public CityService() {
        this.provider = new DataProvider();
        provider.setConnection("city.xml");
    }

    public String addCity(int id, int country_id, String name, int population, String capital) {
        if(isCityAlreadyExist(id))return CityMessageConst.COUNTRY_ALREADY_EXIST;
        List<City> cities = (List<City>) provider.read();
        if (cities == null) cities = new ArrayList<>();
        City city = new City(id, new Country(1, "Ukraine"), name, population, capital);
        cities.add(city);
        provider.write(cities);
        return CityMessageConst.CITY_WAS_ADDED;
    }

    public String showAllCity() {
        String result = "";
        List<City> cities = (List<City>) provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        for (City city : cities) {
            result += city;
        }
        return result;
    }

    public String deleteCityById(int id) {
        List<City> cities = (List<City>) provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().filter((x) -> x.getId() == id).findAny().isPresent()) {
            provider.write(new ArrayList<City>(cities.stream().filter((x) -> x.getId() != id).toList()));
            return CityMessageConst.CITY_WAS_DELETED;
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }

    public String findCityById(int id) {
        List<City> cities = (List<City>) provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().filter((x) -> x.getId() == id).findAny().isPresent()) {
            return cities.stream().filter(x -> x.getId() != id).toList().toString();
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }


    public String changeCityNameById(int id, String name) {
        List<City> cities = (List<City>) provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        for (City city : cities) {
            if (city.getId() == id) {
                city.setName(name);
                provider.write(cities);
                return CityMessageConst.CITY_WAS_CHANGED;
            }
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }
    private boolean isCityAlreadyExist(int id){
        List<City> cities = (List<City>) provider.read();
        return cities.stream().filter(x->x.getId()==id).findAny().isPresent();
    }

}

