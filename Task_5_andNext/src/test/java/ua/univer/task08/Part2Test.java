package ua.univer.task08;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part2Test {
    @Test
    public void part2(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);
        Part2 part2 = new Part2(new String[]{"anesthetist","kitchen","bird","kitchen","kitchen","kitchen","kitchen","anesthetist","anesthetist","anesthetist"});
        part2.show();
        System.setOut(original);
        tps.flush();
        Assert.assertEquals("anesthetist ==> 11" +System.lineSeparator() +
                "kitchen ==> 7"+System.lineSeparator() +
                "bird ==> 4"+System.lineSeparator(),baos.toString());
    }
}
