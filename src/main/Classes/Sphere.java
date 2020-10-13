package main.Classes;

public class Sphere extends Figure {

    private final double pi = 3.14285714286;
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public Sphere(String id, double radius) {
        this.id = id;
        this.radius = radius;
    }

    public Sphere() {
    }

    @Override
    public String getType() {
        return "Sphere";
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateVolume(double... value) {
        double radiusForVolume = super.calculateVolume(value);

        return (4.0/3.0) * pi * (radiusForVolume *radiusForVolume * radiusForVolume);
    }

    public void createSphere() {
        //Create figure and go to interface implemented java class to insert record to database.
        System.out.println("createSphere");
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "id=" + id +
                "radius=" + radius +
                ", content=" + volume +
                '}';
    }
}
