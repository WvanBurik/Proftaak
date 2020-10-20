package main.Classes;

import java.io.*;
import java.sql.SQLException;

public class Hemisphere extends Figure {

    private double radius;
    private final double pi = 3.14285714286;

    public Hemisphere(double radius) {
        this.radius = radius;
    }

    public Hemisphere(String id, double radius) {
        this.id = id;
        this.radius = radius;
    }

    public Hemisphere() {
    }

    @Override
    public String getType() {
        return "Hemisphere";
    }

    public double getRadius() {
        return radius;
    }

    public void createHemisphere() {
        //Create figure and go to interface implemented java class to insert record to database.
        System.out.println("createHemisphere");
    }

    @Override
    public double calculateVolume(double... value) {
        double radiusForVolume = super.calculateVolume(value);

        return (4.0/3.0) * pi * (radiusForVolume *radiusForVolume * radiusForVolume) / 2;
    }

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        HemisphereDAO.deleteHemisphere(selectedIdx);
    }

    @Override
    public String toString() {
        return "Hemisphere{" +
                "{id=" + id +
                "}radius=" + radius + '}';
    }

    public static void writeFigureToFile(Hemisphere hemisphere) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(hemisphere);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }
}
