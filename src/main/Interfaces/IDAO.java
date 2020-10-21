package main.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO {

    public void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException;

    public ArrayList readAllFigures() throws SQLException, ClassNotFoundException;


}
