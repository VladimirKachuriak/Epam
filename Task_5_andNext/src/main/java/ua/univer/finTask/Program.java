package ua.univer.finTask;

import ua.univer.finTask.BLL.City;
import ua.univer.finTask.BLL.CityService;
import ua.univer.finTask.PL.Menu;

public class Program {
    public static void main(String[] args) {
        /*City city = new City(2,new Country(2,"Ukraine"),"Odesza",20000,"Kiev");
        Country country = new Country(2, "5");
        DataProvider dataProvider =new DataProvider();
        dataProvider.write(city);*/
        CityService service = new CityService();
  /*     service.addCity(1,2,"kiev",200,"odesza");
       service.addCity(2,2,"kiev",200,"odesza");
       service.deleteCityById(2);
       service.deleteCityById(1);*/
        //System.out.println(       service.showAllCity());
        Menu menu = new Menu();

    }
}


