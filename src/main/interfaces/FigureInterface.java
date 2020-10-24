package main.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FigureInterface {

    void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException;

    ArrayList readAllFigures() throws SQLException, ClassNotFoundException;

    void insertFigure(double... value) throws SQLException, ClassNotFoundException;
}
