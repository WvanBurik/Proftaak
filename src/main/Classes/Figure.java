package main.Classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Figure {

    protected double volume;
    protected String type;
    private ArrayList<Figure> figures;

    public String getType() {
        return type;
    }

    public Figure() {
        figures = new ArrayList<>();
    }

    public void addFigures(Figure figure) {
        //TODO check if method is required;
        //Might be used to bulk save all records to database;
        //First add all figures to array -> then send array to DAB
        this.figures.addAll(Arrays.asList(figure));
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
        Sphere sphere = new Sphere();

        //Test to see if figure has a specified figure type to create.
        System.out.println("Figure.createFigure figuur klasse is " + figure.toString());

        if (figure.toString().equals(block.toString())) {
            block.createBlock();
        } else if (figure.toString().equals(cilinder.toString())) {
            cilinder.createCilinder();
        } else if (figure.toString().equals(sphere.toString())) {
            sphere.createSphere();
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

    //TODO Fix problems
    //Under construction
    public double calculateTotalContent() throws SQLException, ClassNotFoundException {
        //Select * from database
        // Elk record volume bij elkaar optellen.
        ArrayList<Figure> figures = FigureDAO.readAllFigures();
        for (Figure f : figures) {
            f.calculateVolume();
            System.out.println(f.toString() + f.volume);
        }

        //Eerst huidig record naar database opslaan voor je alles ophaald en berekend.
        return 0.0;
    }
}
