package main.Classes;

public class Circle extends Figure {

    double radius;

    @Override
    public String getType() {
        return "Circle";
    }

    public Circle(double radius) {
        this.radius     = radius;
    }

    public Circle() {
    }

    @Override
    public double calculateVolume(double... value) {
        double radiusForVolume;
        radiusForVolume = super.calculateVolume(value);

        //TODO goede formule maken.
        radiusForVolume *= 2;

        return radiusForVolume;
    }

    public double getRadius() {
        return radius;
    }

    public void createCircle() {
        //Create circle
        System.out.println("createCircle");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", content=" + volume +
                '}';
    }
}
