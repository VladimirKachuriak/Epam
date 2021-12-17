package ua.univer.finTask.BLL;

import ua.univer.finTask.DAL.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CountryService {
    DataProvider provider;

    public CountryService() {
        this.provider = new DataProvider();
        provider.setConnection("Country.xml");
    }

    public String addCountry(int id, String name) {
        List<Country> countries = (List<Country>) provider.read();
        if(isCountryAlreadyExist(id))return CountryMessageConst.COUNTRY_ALREADY_EXIST;
        if (countries == null) countries = new ArrayList<>();
        Country country = new Country(id, name);
        countries.add(country);
        provider.write(countries);
        return CountryMessageConst.COUNTRY_WAS_ADDED;
    }

    public String showAllCountry() {
        String message="";
        List<Country> countries = (List<Country>) provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        for (Country country : countries) {
            message+=country;
        }
        return message;
    }
    public String findCountryById(int id) {
        String message="";
        List<Country> countries = (List<Country>) provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        if(countries.stream().filter(x->x.getId()==id).findAny().isPresent()){
        return countries.stream().filter(x->x.getId()==id).toList().toString();
        }else return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }

    public String deleteCountryByID(int id) {
        List<Country> countries = (List<Country>) provider.read();
        if (countries == null) return CountryMessageConst.NO_COUNTRY_YET;
        if (countries.stream().filter((x) -> x.getId() == id).findAny().isPresent()) {
            provider.write(new ArrayList<Country>(countries.stream().filter((x) -> x.getId() != id).toList()));
            return CountryMessageConst.COUNTRY_WAS_DELETED;
        }
        return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }
    public String changeCountryNameById(int id, String name) {
        List<Country> coutries = (List<Country>) provider.read();
        if (coutries == null) return CountryMessageConst.NO_COUNTRY_YET;
        for (Country country : coutries) {
            if (country.getId() == id) {
                country.setName(name);
                provider.write(coutries);
                return CountryMessageConst.COUNTRY_WAS_CHANGED;
            }
        }
        return CountryMessageConst.NO_COUNTRY_WITH_THIS_ID;
    }
    private boolean isCountryAlreadyExist(int id){
        List<Country> coutries = (List<Country>) provider.read();
        return coutries.stream().filter(x->x.getId()==id).findAny().isPresent();
    }
}
