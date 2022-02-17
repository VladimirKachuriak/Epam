package ua.advanced.practice2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.advanced.practice2.task1.ListImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class City {
    private String city;
    private String Country;
    private int population;

    public City(String city, String country, int population) {
        this.city = city;
        Country = country;
        this.population = population;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        writeJson(gson.toJson(getCityFromXML()));
    }

    public static void writeJson(String json) throws IOException {
        try (FileWriter wr = new FileWriter("src" + File.separator + "main" + File.separator + "java" + File.separator + "ua"
                + File.separator + "advanced" + File.separator + "practice2" + File.separator + "City.json")) {
            wr.write(json);
        }
    }

    public static ListImpl getCityFromXML() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        //doc = db.parse(new File("D:\\Users\\VladimirK\\Documents\\NAU\\gitcom\\Epam\\Task_5_andNext\\src\\main\\java\\ua\\advanced\\practice2\\City.xml"));
        doc = db.parse(new File("src" + File.separator + "main" + File.separator + "java" + File.separator + "ua"
                + File.separator + "advanced" + File.separator + "practice2" + File.separator + "City.xml"));

        ListImpl list = new ListImpl();
        // Получаем корневой элемент
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("cities")) {
            NodeList listCurrency = root.getElementsByTagName("city");
            for (int i = 0; i < listCurrency.getLength(); i++) {
                String cityname = ((Element) listCurrency.item(i)).getElementsByTagName("cityname").item(0).getTextContent();
                String country = ((Element) listCurrency.item(i)).getElementsByTagName("country").item(0).getTextContent();
                int population = Integer.parseInt(((Element) listCurrency.item(i)).getElementsByTagName("population").item(0).getTextContent());
                list.addFirst(new City(cityname, country, population));
            }
            return list;
        } else {
            return null;
        }

    }
}
