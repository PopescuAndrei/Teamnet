package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by Andrei on 4/22/2015.
 */
public class HelloWorldExtend {

    public HelloWorldExtend() {

    }

    public void extendSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        System.out.println("The new Hello World");
    }

    public static void main(String[] args) {
        HelloWorldExtend helloExtend = new HelloWorldExtend();
        helloExtend.extendSayHello();
    }
}
