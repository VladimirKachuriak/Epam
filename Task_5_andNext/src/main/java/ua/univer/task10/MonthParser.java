package ua.univer.task10;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MonthParser {
    public static List<User> getUserFromURLXLS(String url, String month) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        HSSFWorkbook workbook = new HSSFWorkbook(connection.getInputStream());
        HSSFSheet myExcelSheet = workbook.getSheetAt(0);
        HSSFRow row = myExcelSheet.getRow(0);
        List<User> users = new ArrayList<>();
        for (int i = 1; i < row.getLastCellNum(); i++) {
            row = myExcelSheet.getRow(i);
            double sum = 0;
            for (int j = 3; j < 10; j++) {
                sum += row.getCell(j).getNumericCellValue();

            }
            //System.out.format("%.2f \n",sum);
            users.add(new User(row.getCell(1).getStringCellValue(), row.getCell(1).getStringCellValue(), sum, month));
        }
        return users;
    }

    public static List<User> getUserFromURL(String url, String month) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), Charset.forName("UTF-8")))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                users.add(new User(
                        words[0],
                        words[1],
                        Double.parseDouble(words[2].replace(",", ".").replace(" ", "").replace("₴", "")),
                        month
                ));
            }
        }
        return users;
    }

    public static List<User> getUserWithMaxSalary(List<User> users) {
        List<User> maxSalaryUsers = new ArrayList<>();
        User maxSalayUser = users.get(0);
        for (var user : users) {
            if (maxSalayUser.getSalary().compareTo(user.getSalary()) == -1)
                maxSalayUser = user;
        }
        for (var user : users) {
            if (maxSalayUser.getSalary() == user.getSalary())
                maxSalaryUsers.add(user);
        }
        return maxSalaryUsers;
    }

    public static List<User> getUserWithMinSalary(List<User> users) {
        List<User> maxSalaryUsers = new ArrayList<>();
        User maxSalayUser = users.get(0);
        for (var user : users) {
            if (maxSalayUser.getSalary().compareTo(user.getSalary()) == 1)
                maxSalayUser = user;
        }
        for (var user : users) {
            if (maxSalayUser.getSalary() == user.getSalary())
                maxSalaryUsers.add(user);
        }
        return maxSalaryUsers;
    }

    public static BigDecimal getMediumSalary(List<User> users) {
        BigDecimal salary = new BigDecimal("0");
        int counter = 0;
        for (var user : users) {
            counter++;
            salary = salary.add(user.getSalary());
        }
        return salary.divide(new BigDecimal(counter), RoundingMode.HALF_UP);
    }

    public static List<User> getUserWithDespersian(List<User> users) {
        List<User> arr = new ArrayList<>();
        BigDecimal mediumSalary = getMediumSalary(users);
        for (var user : users) {
            if (user.getSalary().compareTo(mediumSalary.multiply(new BigDecimal("0.8"))) == 1 && user.getSalary().compareTo(mediumSalary.multiply(new BigDecimal("1.2"))) == -1) {
                arr.add(user);
            }
        }
        return arr;
    }

    public static List<MonnthSalary> getMonthMediumSalary(List<User> users) {
        List<MonnthSalary> list = new ArrayList<>();
        for (var user : users) {
            if (list.stream().filter((x) -> x.getMonth().equals(user.getMonth())).count() > 0) {
                list.stream().filter((x) -> x.getMonth().equals(user.getMonth())).forEach((x) -> x.setSalary(user.getSalary().add(x.getSalary())));

            } else {
                list.add(new MonnthSalary(user.getMonth(), user.getSalary()));
            }
        }
        return list;
    }

    public static MonnthSalary getMaxSalaryMonth(List<MonnthSalary> list) {
        MonnthSalary temp = list.get(0);
        for (MonnthSalary salary : list) {
            if (temp.getMedium().compareTo(salary.getMedium()) == -1) {
                temp = salary;
            }
        }
        return temp;
    }
}
