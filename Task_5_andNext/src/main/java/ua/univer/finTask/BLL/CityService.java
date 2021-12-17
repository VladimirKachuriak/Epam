package ua.univer.finTask.BLL;

import ua.univer.finTask.DAL.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    DataProvider<List<City>> provider;

    public CityService() {
        this.provider = new DataProvider<>();
        provider.setConnection("city.xml");
    }

    public String addCity(int id, int country_id, String name, int population, CountryService countryService) {

        List<City> cities = provider.read();
        if (cities == null) {
            cities = new ArrayList<>();
        } else {
            if (isCityAlreadyExist(id)) return CityMessageConst.COUNTRY_ALREADY_EXIST;
        }
        if (countryService.getCountryById(country_id) == null) return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
        City city = new City(id, countryService.getCountryById(country_id), name, population);
        cities.add(city);
        provider.write(cities);
        return CityMessageConst.CITY_WAS_ADDED;
    }

    public String setCapitalById(int id) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getId() == id)) {
            int countryId = cities.stream().filter(x -> x.getId() == id).findFirst().get().getCountry().getId();
            cities.stream().filter(x -> x.getCountry().getId() == countryId).forEach(x -> x.setCapital(false));
            for (City city : cities) {
                if (city.getId() == id) {
                    city.setCapital(true);
                    provider.write(cities);
                    return CityMessageConst.CITY_WAS_CHANGED;
                }
            }

        }

        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }


    public String showAllCity() {
        String result = "";
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        for (City city : cities) {
            result += city;
        }
        return result;
    }

    public String deleteCityById(int id) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getId() == id)) {
            provider.write(new ArrayList<>(cities.stream().filter((x) -> x.getId() != id).toList()));
            return CityMessageConst.CITY_WAS_DELETED;
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }

    public void deleteCityByCountry(int id) {
        List<City> cities = provider.read();
        if (cities == null) return;
        provider.write(new ArrayList<>(cities.stream().filter((x) -> x.getCountry().getId() != id).toList()));
    }

    public String findCityById(int id) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getId() == id)) {
            return cities.stream().filter(x -> x.getId() == id).toList().get(0).toString();
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }

    public String findCitiesByCountryId(int id) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getId() == id)) {
            if (cities.stream().anyMatch(x -> x.getCountry().getId() == id)) {
                return cities.stream().filter(x -> x.getCountry().getId() == id).toList().toString();
            }
            return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
        }
        return CityMessageConst.NO_CITY_WITH_THIS_ID;
    }

    public String findAllCityByName(String name) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getName().equals(name))) {
            return cities.stream().filter(x -> x.getName().equals(name)).toList().toString();
        }
        return CityMessageConst.NO_CITY_WITH_THIS_NAME;
    }

    public String findAllCityByPopulation(int population) {
        List<City> cities = provider.read();
        if (cities == null) return CityMessageConst.NO_CITY_YET;
        if (cities.stream().anyMatch(x -> x.getPopulation() == population)) {
            return cities.stream().filter(x -> x.getPopulation() == population).toList().toString();
        }
        return CityMessageConst.NO_CITY_WITH_THIS_POPULATION;
    }

    public String changeCityNameById(int id, String name) {
        List<City> cities = provider.read();
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

    private boolean isCityAlreadyExist(int id) {
        List<City> cities = provider.read();
        return cities.stream().anyMatch(x -> x.getId() == id);
    }

}

