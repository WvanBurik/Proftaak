package main.Classes;

import java.util.Scanner;

public class Block extends Figure {

    private double length;
    private double width;
    private double height;

    public Block(double length, double width, double height) {
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

    public void createBlock() {
        //Create figure and go to interface implemented java class to insert record to database.
        System.out.println("Create block");
    }

    @Override
    public String toString() {
        return "Block{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", content=" + volume +
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
}
