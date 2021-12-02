package ua.univer.task08;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("============Task1=================");
        Scanner scan = new Scanner(new File("src/main/java/ua/univer/task08/text1.csv"));
        String str = scan.nextLine();
        String[] words = str.split(";");
        Part1 arr = new Part1(words);

        System.out.println("============Task2=================");
        Scanner scan2 = new Scanner(new File("src/main/java/ua/univer/task08/text2.csv"));
        String str2 = scan2.nextLine();
        String[] words2 = str2.split(";");
        Part2 part2 = new Part2(words2);
        part2.show();
        System.out.println("==============Task3===============");
        Scanner scan3 = new Scanner(new File("src/main/java/ua/univer/task08/text3.csv"));
        String str3 = scan3.nextLine();
        String[] words3 = str3.split(";");
        Part3.result(words3);


    }


}
