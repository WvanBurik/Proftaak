package main.Classes;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    public double calculateVolume(double... value) {
        double radiusForVolume = super.calculateVolume(value);

        return (4.0/3.0) * pi * (radiusForVolume *radiusForVolume * radiusForVolume) / 2;
    }

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        HemisphereDAO hemisphereDAO = new HemisphereDAO();
        hemisphereDAO.deleteFigure(selectedIdx);
    }

    public static void createHemisphere(double radius) throws SQLException, ClassNotFoundException {
        HemisphereDAO hemisphereDAO = new HemisphereDAO();
        hemisphereDAO.insertFigure(radius);
    }

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        HemisphereDAO hemisphereDAO = new HemisphereDAO();
        return hemisphereDAO.readAllFigures();
    }

    public static Hemisphere readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        HemisphereDAO hemisphereDAO = new HemisphereDAO();
        return hemisphereDAO.readFigure(selectedIdx);
    }


    @Override
    public String toString() {
        return "Hemisphere{" +
                "{id=" + id +
                "}radius=" + radius + '}';
    }

    public static void writeFigureToFile(Hemisphere hemisphere) {
        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Hemisphere.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(hemisphere);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        Hemisphere.writeFigureToTxt(hemisphere);
    }

    private static void writeFigureToTxt(Hemisphere hemisphere) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Hemisphere.txt"));
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
