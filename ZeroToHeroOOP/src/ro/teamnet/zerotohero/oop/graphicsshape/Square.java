package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by andre on 4/21/2015.
 */
public class Square extends Shape {

    private int side;


    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String toString() {
        return "sides = " + side;
    }
}
