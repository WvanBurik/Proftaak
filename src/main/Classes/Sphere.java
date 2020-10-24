package main.Classes;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
        SphereDAO sphereDAO = new SphereDAO();
        sphereDAO.deleteFigure(selectedIdx);
    }

    public static void createSphere(double radius) throws SQLException, ClassNotFoundException {
        SphereDAO sphereDAO = new SphereDAO();
        sphereDAO.insertFigure(radius);
    }

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        SphereDAO sphereDAO = new SphereDAO();
        return sphereDAO.readAllFigures();
    }

    public static Sphere readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        SphereDAO sphereDAO = new SphereDAO();
        return sphereDAO.readFigure(selectedIdx);
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
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Sphere.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(sphere);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        Sphere.writeFigureToTxt(sphere);
    }

    public static void writeFigureToTxt(Sphere sphere) {
        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Sphere.txt"));
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
