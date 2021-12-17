package ua.univer.finTask.BLL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.univer.finTask.DAL.Filepath;

import java.io.File;

import static org.junit.Assert.*;

public class CityServiceTest {
    @Before
    public void clearFiles() {
        File file = new File(Filepath.Path+"city.xml");
        file.delete();
        File file1 = new File(Filepath.Path+"country.xml");
        file1.delete();
    }

    @Test
    public void addCity() {
        new CountryService().addCountry(1, "German");
        Assert.assertEquals(CityMessageConst.CITY_WAS_ADDED, new CityService().addCity(1, 1, "Kiev", 200, new CountryService()));
    }

    @Test
    public void showAllCity() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        service.addCity(2, 1, "Dnepr", 200, new CountryService());
        Assert.assertEquals("\nCity{id=1, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}\n" +
                "City{id=2, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}", service.showAllCity());
    }

    @Test
    public void deleteCityById() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        Assert.assertEquals(CityMessageConst.CITY_WAS_DELETED,service.deleteCityById(1));
    }


    @Test
    public void findCityById() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        service.addCity(2, 1, "Dnepr", 200, new CountryService());
        Assert.assertEquals("\nCity{id=2, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}", service.findCityById(2));
    }

    @Test
    public void findCitiesByCountryId() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        service.addCity(2, 1, "Dnepr", 200, new CountryService());
        Assert.assertEquals("[\n" +
                "City{id=1, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}, \n" +
                "City{id=2, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}]", service.findCitiesByCountryId(1));
    }

    @Test
    public void findAllCityByName() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        service.addCity(2, 1, "Dnepr", 200, new CountryService());
        Assert.assertEquals("[\n" +
                "City{id=1, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}]", service.findAllCityByName("Kiev"));
    }

    @Test
    public void findAllCityByPopulation() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        service.addCity(2, 1, "Dnepr", 200, new CountryService());
        Assert.assertEquals("[\n" +
                "City{id=1, country=Country{id=1, name='German'}, name='Kiev', population=200, capital='false'}, \n" +
                "City{id=2, country=Country{id=1, name='German'}, name='Dnepr', population=200, capital='false'}]", service.findAllCityByPopulation(200));
    }

    @Test
    public void changeCityNameById() {
        new CountryService().addCountry(1, "German");
        CityService service = new CityService();
        service.addCity(1, 1, "Kiev", 200, new CountryService());
        assertEquals(CityMessageConst.CITY_WAS_CHANGED,service.changeCityNameById(1,"Dnepr"));
    }
}