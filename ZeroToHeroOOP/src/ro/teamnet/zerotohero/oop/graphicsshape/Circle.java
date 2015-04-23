package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by andre on 4/21/2015.
 */
public class Circle extends Shape {

    private int xPos, yPos, radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 5;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 5;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
        this.yPos = 0;
        this.radius = 2;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return java.lang.Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + ", " + yPos + ") and radius = " + radius;
    }

    public void fillColor(){
        System.out.println(super.color);
    }

    public void fillColor(int color){
        super.color = color;
        System.out.println("The new default color is " + color);
    }

    public void fillColor(float saturation){
        super.saturation = saturation;
        System.out.println("The new default saturation is " + saturation);
    }

}
