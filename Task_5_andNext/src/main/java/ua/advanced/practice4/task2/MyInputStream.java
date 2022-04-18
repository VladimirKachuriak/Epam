package ua.advanced.practice4.task2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MyInputStream extends InputStream {
    private boolean flag = false;
    @Override
    public int read() throws IOException {
        if(flag){
            flag = false;
            //the sign that there is no data in the input stream anymore
            return -1;
        }
        flag = true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new String("\n").getBytes(StandardCharsets.UTF_8)[0];
    }
}
