package main.Classes;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Figure implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String id;
    protected double volume;
    protected String type;
    private ArrayList<Figure> figures;

    public String getType() {
        return type;
    }

    public Figure() {
        figures = new ArrayList<>();
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


}
