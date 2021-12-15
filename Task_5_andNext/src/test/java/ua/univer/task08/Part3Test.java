package ua.univer.task08;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part3Test {
    @Test
    public void part3(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);
        Part3.result(new String[]{"panda","aubergine","monkey","cat","panda","aubergine","monkey"});
        System.setOut(original);
        tps.flush();
        Assert.assertEquals("ADNAP" +System.lineSeparator() +
                "ENIGREBUA"+System.lineSeparator() +
                "YEKNOM"+System.lineSeparator(),baos.toString());
    }
}
