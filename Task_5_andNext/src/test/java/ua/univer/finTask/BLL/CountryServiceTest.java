package ua.univer.finTask.BLL;

import org.junit.Before;
import org.junit.Test;
import ua.univer.finTask.DAL.Filepath;

import java.io.File;

import static org.junit.Assert.*;

public class CountryServiceTest {
    @Before
    public void clearFiles() {
        File file = new File(Filepath.Path+"city.xml");
        file.delete();
        File file1 = new File(Filepath.Path+"country.xml");
        file1.delete();
    }

    @Test
    public void addCountry() {
        assertEquals(CountryMessageConst.COUNTRY_WAS_ADDED,new CountryService().addCountry(3,"German"));
        assertEquals(CountryMessageConst.COUNTRY_ALREADY_EXIST,new CountryService().addCountry(3,"German"));
    }

    @Test
    public void showAllCountry() {
        CountryService countryService=new CountryService();
        new CountryService().addCountry(3,"German");
        new CountryService().addCountry(4,"France");
        assertEquals("Country{id=3, name='German'}Country{id=4, name='France'}",countryService.showAllCountry());
    }

    @Test
    public void findCountryById() {
        CountryService countryService=new CountryService();
        new CountryService().addCountry(3,"German");
        new CountryService().addCountry(4,"France");
        assertEquals("[Country{id=4, name='France'}]",countryService.findCountryById(4));
    }

    @Test
    public void deleteCountryByID() {
        CountryService countryService=new CountryService();
        new CountryService().addCountry(3,"German");
        new CountryService().addCountry(4,"France");
        assertEquals(CountryMessageConst.COUNTRY_WAS_DELETED,countryService.deleteCountryByID(4, new CityService()));
    }

    @Test
    public void changeCountryNameById() {
        CountryService countryService=new CountryService();
        new CountryService().addCountry(3,"German");
        new CountryService().addCountry(4,"France");
        assertEquals(CountryMessageConst.COUNTRY_WAS_CHANGED,countryService.changeCountryNameById(4,"England"));
    }

}