package main.Classes;

public class Circle extends Figure {

    double radius;

    public Circle(double radius) {
        this.radius     = radius;
    }

    public Circle() {
    }

    public void createCircle() {
        //Create circle
        System.out.println("createCircle");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", content=" + content +
                '}';
    }
}
