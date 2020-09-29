package main.Classes;

public class Cilinder extends Figure {

    private double height;
    private double radius;
    private final double pi = 3.14285714286;

    public Cilinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public Cilinder() {
    }

    @Override
    public String getType() {
        return "Cilinder";
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateVolume(double... value) {
        double heightOfCilinder = value[0];
        double radiusOfCilinder = value[1];

        return super.calculateVolume(pi, (radiusOfCilinder * radiusOfCilinder), heightOfCilinder);
    }

    public void createCilinder() {
        //Create figure and go to interface implemented java class to insert record to database.
        System.out.println("create cilinder");
    }

    @Override
    public String toString() {
        return "Cilinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", content=" + volume +
                '}';
    }
}
