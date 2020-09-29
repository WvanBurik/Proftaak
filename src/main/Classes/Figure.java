package main.Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Figure {
    double volume;
    String type;

    public String getType() {
        return type;
    }

    //Calculate method for each child class.
    public double calculateVolume(double... value) {
        volume = value[0];

        for (int i = 1; i < value.length; i++) {
            this.volume = volume * value[i];
        }

        return volume;
    }

    public Figure loadFigure() {
        //Read a specific Figure from the database and pop it up in window.
        return null;
    }

    public void createFigure(Figure figure) {
        //Create a new figure
        Block block = new Block();
        Cilinder cilinder = new Cilinder();
        Circle circle = new Circle();

        //Test to see if figure has a specified figure type to create.
        System.out.println("Figure.createFigure figuur klasse is " + figure.toString());

        if (figure.toString().equals(block.toString())) {
            block.createBlock();
        } else if (figure.toString().equals(cilinder.toString())) {
            cilinder.createCilinder();
        } else if (figure.toString().equals(circle.toString())) {
            circle.createCircle();
        }

//        switch(figure.toString()) {
//            case block.toString():
//                // code block
//                break;
//            case cilinder:
//                // code block
//                break;
//            default:
//                // code block
//        }
    }

    public void deleteFigure() {
        //Delete a specific figure.
    }

    public void saveFigure() {
        //Save the figure.
        //May be deleted.
    }

    public double calculateTotalContent() {
        //Select * from database
        // Elk record volume bij elkaar optellen.


        //Eerst huidig record naar database opslaan voor je alles ophaald en berekend.
        return 0.0;
    }
}
