package main.Classes;

import java.io.*;

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

    @Override
    public String getType() {
        return "Pyramid";
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

    @Override
    public String toString() {
        return "Pyramid{" +
                "id=" + id +
                "height=" + height +
                ", baseLength=" + baseLength +
                '}';
    }

    public static void writeFigureToFile(Pyramid pyramid) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
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
