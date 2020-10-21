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


}
