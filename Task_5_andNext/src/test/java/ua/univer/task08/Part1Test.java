package ua.univer.task08;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part1Test {
    @Test
    public void part1(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);
        Part1 part1 = new Part1(new String[]{"baba","yaya","to"});
        System.setOut(original);
        tps.flush();
        Assert.assertEquals("yaya==>1" +System.lineSeparator() +
                "to==>1"+System.lineSeparator() +
                "baba==>1"+System.lineSeparator(),baos.toString());
    }
}
