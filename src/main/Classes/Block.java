package main.Classes;

import java.util.Scanner;

public class Block extends Figure {

    double length;
    double width;
    double height;

    public Block(double length, double width, double height) {
        this.length     = length;
        this.width      = width;
        this.height     = height;
    }

    public Block() {
    }

    @Override
    public String toString() {
        return "Block{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", content=" + content +
                '}';
    }

    public void createBlock() {
        //Create block
        System.out.println("Create block");
    }

    public String calculateContentTEST() {
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
        content = block.calculateContent(length, width, height);

        System.out.println(content);
        return "" + content;
    }
}
