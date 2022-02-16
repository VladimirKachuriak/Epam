package ua.advanced.practice2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class City {
    private String city;
    private String Country;
    private int population;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        //doc = db.parse(new File("D:\\Users\\VladimirK\\Documents\\NAU\\gitcom\\Epam\\Task_5_andNext\\src\\main\\java\\ua\\advanced\\practice2\\City.xml"));
        doc = db.parse(new File("src"+File.separator+"main"+File.separator+"java"+File.separator+"ua"
                +File.separator+"advanced"+File.separator+"practice2"+File.separator+"City.xml"));

        // Получаем корневой элемент
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("cities")){
            NodeList listCurrency = root.getElementsByTagName("city");
            for (int i=0; i<listCurrency.getLength(); i++){
                System.out.printf(String.valueOf(listCurrency.getLength()));
                String cc = ((Element)listCurrency.item(i)).getElementsByTagName("cityname").item(0).getTextContent();
                String txt = ((Element)listCurrency.item(i)).getElementsByTagName("country").item(0).getTextContent();
                String rate =  ((Element)listCurrency.item(i)).getElementsByTagName("population").item(0).getTextContent();
                System.out.println(cc + ", "+txt+" = "+rate);
            }
        }else{
            System.out.printf("adfs");
        }

    }
}
