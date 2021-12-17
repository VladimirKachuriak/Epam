package ua.univer.finTask.PL;

import ua.univer.finTask.BLL.CityMessageConst;
import ua.univer.finTask.BLL.CityService;
import ua.univer.finTask.BLL.Country;
import ua.univer.finTask.BLL.CountryService;

import java.util.Scanner;

public class Menu {
    public Menu() {
        CityService cityService = new CityService();
        CountryService countryService = new CountryService();
        while (true) {
            System.out.println("1 - Add city");
            System.out.println("2 - Delete city by id");
            System.out.println("3 - show cities");
            System.out.println("4 - show cities by ID");
            System.out.println("5 - show cities with correspond population");
            System.out.println("6 - show cities with correspond name");
            System.out.println("7 - Add country");
            System.out.println("8 - Delete country by id");
            System.out.println("9 - show all countries");
            System.out.println("10 - find country by ID");
            System.out.println("11 - show all cities of the country by id");
            switch (getNumber("Please, enter number of comamand")) {
                case 1: {
                   showResult(cityService.addCity(getNumber(CityMenuMessage.ENTER_ID),getNumber(CountryMenuMessage.ENTER_ID),
                           getString(CityMenuMessage.ENTER_NAME),getNumber(CityMenuMessage.ENTER_POPULATION),countryService));
                }
                break;
                case 2: {
                        showResult(cityService.deleteCityById(getNumber(CityMenuMessage.ENTER_ID_FOR_DELETE)));
                }
                break;
                case 3: {
                    showResult(cityService.showAllCity());
                }
                break;
                case 4: {
                   showResult(cityService.findCityById(getNumber(CityMenuMessage.ENTER_ID_FOR_FIND)));
                }
                break;
                case 5: {
                    showResult(cityService.findAllCityByName(getString(CityMenuMessage.ENTER_NAME)));
                }
                break;
                case 6: {
                    showResult(cityService.findAllCityByPopulation(getNumber(CityMenuMessage.ENTER_POPULATION)));
                }
                break;
                case 7: {
                        showResult(countryService.addCountry(getNumber(CountryMenuMessage.ENTER_ID),getString(CountryMenuMessage.ENTER_NAME)));
                }
                break;
                case 8: {
                    showResult(countryService.deleteCountryByID(getNumber(CountryMenuMessage.ENTER_ID_FOR_DELETE),cityService));
                }
                break;
                case 9: {
                    showResult(countryService.showAllCountry());
                }
                break;
                case 10: {
                     showResult(countryService.findCountryById(getNumber(CountryMenuMessage.ENTER_ID_FOR_FIND)));
                }
                break;
                case 11: {
                    showResult(cityService.findCitiesByCountryId(getNumber(CountryMenuMessage.ENTER_ID_FOR_FIND)));
                }
                break;
            }
        }
    }

    private int getNumber(String message) {
        System.out.println((message));
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return scan.nextInt();

            } catch (Exception e) {
                System.out.println(("That's not a number. Try again"));
            }

        }
    }

    private String getString(String message) {
        {
            System.out.println((message));
            Scanner scan = new Scanner(System.in);
            return scan.nextLine();
        }
    }
    private void showResult(String result){
        System.out.println(result);
    }
}

