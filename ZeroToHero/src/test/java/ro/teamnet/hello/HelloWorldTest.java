package ro.teamnet.hello;

import com.sun.media.jfxmedia.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Andrei on 4/22/2015.
 */
public class HelloWorldTest {
    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HelloWorld.class.getName());
    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();

    }

    @Test
    public void testReturnHelloKey() {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }

    @Test
    public void testReturnList() {
        HelloWorld helloWorld = new HelloWorld();
        assert HelloWorld.returnList().contains("string1");
        assert HelloWorld.returnList().size() >= 2;

        List<String> forTestList = HelloWorld.returnList();
        for (String s : forTestList) {
            Assert.assertTrue(s.length() > 2);
        }

        Assert.assertTrue(forTestList instanceof ArrayList);
        ArrayList<ModelSomething> list = new ArrayList<ModelSomething>(HelloWorld.getListModels());
        HelloWorld.addInfoToList(new ModelSomething("Titlu","Descriere",5));
        HelloWorld.addInfoToList(new ModelSomething("Titlu2","Descriere2", 3));
        logger.debug("Initial List is " + list.size() + " and the Final List is " + HelloWorld.getListModels().size());
        Assert.assertTrue(HelloWorld.getListModels().size() > list.size());

    }

}
