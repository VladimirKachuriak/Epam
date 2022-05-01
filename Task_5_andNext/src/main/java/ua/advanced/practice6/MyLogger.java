package ua.advanced.practice6;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    public static Logger logger = Logger.getLogger(MyLogger.class.getSimpleName());
    static {
        try {
            Handler fh = new FileHandler("MyLogger.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
