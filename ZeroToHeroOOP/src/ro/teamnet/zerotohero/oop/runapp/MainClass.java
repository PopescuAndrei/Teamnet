package ro.teamnet.zerotohero.oop.runapp;

import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zerotohero.Canvas;
import ro.teamnet.zerotohero.oop.graphicsshape.*;

/**
 * Created by andre on 4/21/2015.
 */
public class MainClass {


    public static void main(String[] args) {

        Circles circles = new Circles();
        System.out.println("The default circle area is " + circles.getAreaPub());


        Circle c = new Circle(2, 4, 3);
        Shape c2 = new Circle(10);
        ShapeBehaviour square = new Square(5);
        System.out.println();
        System.out.println("---Polymorphism---");
        System.out.println("The circle with " + c.toString() + " has an area of " + c.getRadius() * c.getRadius() * Math.PI);
        System.out.println("The circle with " + c2.toString() + " has an area of " + c2.area());
        System.out.println("The square with" + square.toString() + "has an area of" + square.area());
        c.fillColor(1);
        c.fillColor(2f);
        circles.getAreaDef();
        Canvas canvas = new Canvas();
        //does not work with the default canvas.getArea()
    }
}
