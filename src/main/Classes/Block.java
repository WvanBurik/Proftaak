package main.Classes;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Block extends Figure {

    private static final long serialVersionUID = 1L;
    private double length;
    private double width;
    private double height;

    public Block(double length, double width, double height) {
        this.length     = length;
        this.width      = width;
        this.height     = height;
    }

    public Block(String id, double length, double width, double height) {
        this.id = id;
        this.length     = length;
        this.width      = width;
        this.height     = height;
    }

    public Block() {
    }


    @Override
    public String getType() {
        return "Block";
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void createBlock(double length, double width, double height) throws SQLException, ClassNotFoundException {
        //Create figure and go to interface implemented java class to insert record to database.
        BlockDAO.insertBlock(length, width, height);
        System.out.println("Create block");
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public String calculateVolume() {
        double length;
        double width;
        double height;
        double content;

        System.out.println("Wat is de lengte?");
        Scanner scan = new Scanner(System.in);
        length = Double.valueOf(scan.nextLine());

        System.out.println("Wat is de breete?");
        scan = new Scanner(System.in);
        width = Double.valueOf(scan.nextLine());

        System.out.println("Wat is de hoogte?");
        scan = new Scanner(System.in);
        height = Double.valueOf(scan.nextLine());

        Block block = new Block(length, width, height);
        content = block.calculateVolume(length, width, height);

        System.out.println(content);
        return "" + content;
    }

    public static void writeFigureToFile(Block block) {

        try {
            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(block);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }
}
