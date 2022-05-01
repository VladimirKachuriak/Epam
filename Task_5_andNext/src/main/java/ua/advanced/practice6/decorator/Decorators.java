package ua.advanced.practice6.decorator;

import ua.advanced.practice6.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        MyLogger.logger.log(Level.CONFIG,"Start decorator evenIndexElementsSubList");
        List<String> list= new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i+=2) {
             MyLogger.logger.log(Level.ALL,"Decorator iteration :"+i);
             list.add(sourceList.get(i));
        }
        return list;
    }
}
