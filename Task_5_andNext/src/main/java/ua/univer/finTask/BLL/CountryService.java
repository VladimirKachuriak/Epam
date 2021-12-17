package ua.univer.finTask.BLL;

import ua.univer.finTask.DAL.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CountryService {
    DataProvider<List<Country>> provider;

    public CountryService() {
        this.provider = new DataProvider<>();
        provider.setConnection("Country.xml");
    }

    public String addCountry(int id, String name) {
        List<Country> countries = provider.read();
        if(countries==null){countries=new ArrayList<>();
        }else {
            if (isCountryAlreadyExist(id)) return CountryMessageConst.COUNTRY_ALREADY_EXIST;
        }
        Country country = new Country(id, name);
        countries.add(country);
        provider.write(countries);
        return CountryMessageConst.COUNTRY_WAS_ADDED;
    }

    public String showAllCountry() {
        String message="";
        List<Country> countries = provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        for (Country country : countries) {
            message+=country;
        }
        return message;
    }
    public String findCountryById(int id) {
        String message="";
        List<Country> countries = provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        if(countries.stream().anyMatch(x->x.getId()==id)){
        return countries.stream().filter(x->x.getId()==id).toList().toString();
        }else return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }

    public String deleteCountryByID(int id,CityService service) {
        List<Country> countries = provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        if (countries.stream().anyMatch(x -> x.getId() == id)) {
            provider.write(new ArrayList<>(countries.stream().filter(x -> x.getId() != id).toList()));
            service.deleteCityByCountry(id);
            return CountryMessageConst.COUNTRY_WAS_DELETED;
        }
        return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }
    public String changeCountryNameById(int id, String name) {
        List<Country> countries = provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        for (Country country : countries) {
            if (country.getId() == id) {
                country.setName(name);
                provider.write(countries);
                return CountryMessageConst.COUNTRY_WAS_CHANGED;
            }
        }
        return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }
    public Country getCountryById(int id){
        List<Country> countries = provider.read();
        if(countries.stream().anyMatch(x->x.getId()==id))return countries.stream().filter(x->x.getId()==id).findFirst().get();
        return null;
    }
    private boolean isCountryAlreadyExist(int id){
        List<Country> countries = provider.read();
        return countries.stream().anyMatch(x->x.getId()==id);
    }

}
