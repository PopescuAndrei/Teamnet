package ro.teamnet.hello;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 4/22/2015.
 */
public class HelloWorld {
    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());
    static List<String> strings;
    static ArrayList<ModelSomething> modelSomethingList = new ArrayList<ModelSomething>();
    /**
     * method for saying hello
     */
    public void sayHello() {
        System.out.println("Hello World!");
        logger.debug("DEBUG -> Enters in sayHello() method from HelloWorld");
        logger.info("INFO -> Enters in returnHelloKey from HelloWorld");
    }

    /**
     * method for returning a key
     *
     * @return - The HelloWorld key
     */
    public String returnHelloKey() {
        return "HelloKey";
    }

    /**
     * method for returning a list
     *
     * @return - The List with 2 elements
     */
    public static List<String> returnList() {
        strings = new ArrayList<String>();
        strings.add("string1");
        strings.add("string2");
        return strings;
    }

    public static void addInfoToList(ModelSomething modelSomething){
        modelSomethingList.add(modelSomething);
    }

    public static ArrayList<ModelSomething> getListModels(){
        return modelSomethingList;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();

    }


}
