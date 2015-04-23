package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by andre on 4/21/2015.
 */
public class Point {
    private int xPos,yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (xPos != point.xPos) return false;
        return yPos == point.yPos;

    }

    @Override
    public int hashCode() {
        int result = xPos;
        result = 31 * result + yPos;
        return result;
    }
}
