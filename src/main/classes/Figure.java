package main.classes;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Figure implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String id;
    protected double volume;

    public Figure() {
    }


    //Calculate method for each child class.
    public double calculateVolume(double... value) {
        volume = value[0];

        for (int i = 1; i < value.length; i++) {
            this.volume = volume * value[i];
        }

        return volume;
    }

    //Method used for WriteToFile button in controller
    public static void switchFigureToWriteToFile(String selectedFigure) throws SQLException, ClassNotFoundException {
        String DBId = selectedFigure.substring(selectedFigure.indexOf("{id") + 4, selectedFigure.indexOf("}"));

        String toStringVal = selectedFigure;
        int iend = toStringVal.indexOf("{");
        String classString = "";

        if (iend != -1)
        {
            classString= toStringVal.substring(0 , iend); //this will give abc
        }

        switch(classString) {
            case "Block":
                Block block = Block.readFigure(DBId);
                Block.writeFigureToFile(block);
                break;
            case "Cilinder":
                Cilinder cilinder = Cilinder.readFigure(DBId);
                Cilinder.writeFigureToFile(cilinder);
                break;
            case "Hemisphere":
                Hemisphere hemisphere = Hemisphere.readFigure(DBId);
                Hemisphere.writeFigureToFile(hemisphere);
                break;
            case "Pyramid":
                Pyramid pyramid = Pyramid.readFigure(DBId);
                Pyramid.writeFigureToFile(pyramid);
                break;
            case "Sphere":
                Sphere sphere = Sphere.readFigure(DBId);
                Sphere.writeFigureToFile(sphere);
                break;
        }
    }

    //Select all Figures from DB
    //Returns an ArrayList containing figures.
    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        ArrayList<Figure> figures = new ArrayList<>();

        ArrayList<Block> blocks = Block.readAllFigures();
        ArrayList<Cilinder> cilinders = Cilinder.readAllFigures();
        ArrayList<Hemisphere> hemispheres = Hemisphere.readAllFigures();
        ArrayList<Pyramid> pyramids = Pyramid.readAllFigures();
        ArrayList<Sphere> spheres = Sphere.readAllFigures();

        figures.addAll(blocks);
        figures.addAll(cilinders);
        figures.addAll(hemispheres);
        figures.addAll(pyramids);
        figures.addAll(spheres);

        return figures;
    }


    //Select all Figures From DB and adds all volumes together.
    //Returns a double value of all volumes combined.
    public static double readAllFiguresForTotalVolume() throws SQLException, ClassNotFoundException {
        double totalVolume = 0;

        ArrayList<Block> blocks = Block.readAllFigures();
        ArrayList<Cilinder> cilinders = Cilinder.readAllFigures();
        ArrayList<Hemisphere> hemispheres = Hemisphere.readAllFigures();
        ArrayList<Pyramid> pyramids = Pyramid.readAllFigures();
        ArrayList<Sphere> spheres = Sphere.readAllFigures();

        for (Block b : blocks) {
            totalVolume += b.calculateVolume(b.getLength(), b.getWidth(), b.getHeight());
        }
        for (Cilinder c : cilinders) {
            totalVolume += c.calculateVolume(c.getHeight(), c.getRadius());
        }
        for (Hemisphere h : hemispheres) {
            totalVolume += h.calculateVolume(h.getRadius());
        }
        for (Pyramid p : pyramids) {
            totalVolume += p.calculateVolume(p.getHeight(), p.getBaseLength());
        }
        for (Sphere s : spheres) {
            totalVolume += s.calculateVolume(s.getRadius());
        }
        return totalVolume;
    }

}
