package main.classes;

import main.dao.PyramidDAO;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pyramid extends Figure {

    private double height;
    private double baseLength;

    public Pyramid(double height, double baseLength) {
        this.height = height;
        this.baseLength = baseLength;
    }

    public Pyramid(String id, double height, double baseLength) {
        this.id = id;
        this.height = height;
        this.baseLength = baseLength;
    }

    public Pyramid() {
    }

    public double getHeight() {
        return height;
    }

    public double getBaseLength() {
        return baseLength;
    }

    @Override
    public double calculateVolume(double... value) {
        double baseH = value[0];
        double baseL = value[1];

        double volumeOfPyramid = super.calculateVolume(baseH, (baseL * baseL));

        return volumeOfPyramid / 3;
    }

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        PyramidDAO pyramidDAO = new PyramidDAO();
        pyramidDAO.deleteFigure(selectedIdx);
    }

    public static void createPyramid(double height, double baseLength) throws SQLException, ClassNotFoundException {
        PyramidDAO pyramidDAO = new PyramidDAO();
        pyramidDAO.insertFigure(height, baseLength);
    }

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        PyramidDAO pyramidDAO = new PyramidDAO();
        return pyramidDAO.readAllFigures();
    }

    public static Pyramid readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        PyramidDAO pyramidDAO = new PyramidDAO();
        return pyramidDAO.readFigure(selectedIdx);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "{id=" + id +
                "}height=" + height +
                ", baseLength=" + baseLength +
                '}';
    }

    public static void writeFigureToFile(Pyramid pyramid) {
        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Pyramid.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(pyramid);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        Pyramid.writeFigureToTxt(pyramid);
    }

    private static void writeFigureToTxt(Pyramid pyramid) {
        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\Pyramid.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(pyramid);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
