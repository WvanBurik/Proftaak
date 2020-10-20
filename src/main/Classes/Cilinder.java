package main.Classes;

import java.io.*;

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
                "id=" + id +
                "height=" + height +
                ", radius=" + radius +
                ", volume=" + volume +
                '}';
    }

    public static void writeFigureToFile(Cilinder cilinder) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
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

    public static void writeFigureToFileAsText(Cilinder cilinder) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.txt"));
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
