package main.classes;

import main.dao.CilinderDAO;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cilinder extends Figure {

    private static final long serialVersionUID = 1L;
    private double height;
    private double radius;
    private final double pi = 3.14285714286;

    public Cilinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public Cilinder(String id, double height, double radius) {
        this.id = id;
        this.height = height;
        this.radius = radius;
    }

    public Cilinder() {
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

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        CilinderDAO cilinderDAO = new CilinderDAO();
        cilinderDAO.deleteFigure(selectedIdx);
    }

    public static void createCilinder(double height, double radius) throws SQLException, ClassNotFoundException {
        CilinderDAO cilinderDAO = new CilinderDAO();
        cilinderDAO.insertFigure(height, radius);
    }

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        CilinderDAO cilinderDAO = new CilinderDAO();
        return cilinderDAO.readAllFigures();
    }

    public static Cilinder readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        CilinderDAO cilinderDAO = new CilinderDAO();
        return cilinderDAO.readFigure(selectedIdx);
    }

    @Override
    public String toString() {
        return "Cilinder{" +
                "{id=" + id +
                "}height=" + height +
                ", radius=" + radius +
                '}';
    }

    public static void writeFigureToFile(Cilinder cilinder) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Cilinder.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(cilinder);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        Cilinder.writeFigureToTxt(cilinder);
    }

    private static void writeFigureToTxt(Cilinder cilinder) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Cilinder.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(cilinder);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
