package main.Classes;

import java.io.*;
import java.sql.SQLException;

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

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        SphereDAO.deleteSphere(selectedIdx);
    }

    public void createSphere() {
        //Create figure and go to interface implemented java class to insert record to database.
        System.out.println("createSphere");
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "{id=" + id +
                "}radius=" + radius +
                '}';
    }

    public static void writeFigureToFile(Sphere sphere) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(sphere);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
