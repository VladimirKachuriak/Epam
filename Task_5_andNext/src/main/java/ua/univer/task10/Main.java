package ua.univer.task10;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<User> users2 = MonthParser.getUserFromURL(" https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/d2b1a7d2-9222-4dfa-b57e-c0bb0b21485b/download/sichen-zp-2019.csv", "sichen");
        users2.addAll(MonthParser.getUserFromURL("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/38ef4e5e-72ec-4715-95d7-28c0fd42176c/download/liutii-zp-2019.csv", "liutii"));
        users2.addAll(MonthParser.getUserFromURL("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/953aae94-8c82-4296-881f-f57b3a7be389/download/berezen-2019.csv", "berezen"));
        users2.addAll(MonthParser.getUserFromURL("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/edd8e5e6-4f95-4e61-a400-d1cf3994a43e/download/zp-kviten-2019.csv", "kviten"));

        System.out.println(MonthParser.getUserWithMaxSalary(users2));
        System.out.println(MonthParser.getUserWithMinSalary(users2));
        System.out.println(MonthParser.getMediumSalary(users2));
        System.out.println(MonthParser.getUserWithDespersian(users2));
        System.out.println("////////////");
        System.out.println(MonthParser.getMonthMediumSalary(users2));
        System.out.println(MonthParser.getMaxSalaryMonth(MonthParser.getMonthMediumSalary(users2)));


/*
        System.out.println(getUserWithMaxSalary(users2));
        List<User> users = getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/738a945e-a8f7-4a92-9442-5d1b3d61f4e6/download/rozrakhunkovo-platizhna-01-21.xls");
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/7200c92d-9743-423a-bd3e-0bcf8064c1f9/download/rozrakhunkovo-platizhna-02-21.xls"));
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/7200c92d-9743-423a-bd3e-0bcf8064c1f9/download/rozrakhunkovo-platizhna-03-21.xls"));
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/7200c92d-9743-423a-bd3e-0bcf8064c1f9/download/rozrakhunkovo-platizhna-04-21.xls"));
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/7200c92d-9743-423a-bd3e-0bcf8064c1f9/download/rozrakhunkovo-platizhna-05-21.xls"));
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/7200c92d-9743-423a-bd3e-0bcf8064c1f9/download/rozrakhunkovo-platizhna-06-21.xls"));
        users.addAll(getUserFromURLXLS("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/0afc7843-4940-4868-aa8b-c776ae0b933b/download/rozrakhunkovo-platizhna-07-21.xls"));*/

        //System.out.println(getUserWithMaxSalary(users));


    }

}
