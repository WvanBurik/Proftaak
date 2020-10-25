package main.dao;

import main.dab.DBUtil;
import main.classes.Hemisphere;
import main.interfaces.FigureInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class HemisphereDAO implements FigureInterface {

    @Override
    public void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM hemisphere where id = '" + selectedIdx + "';";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM hemisphere;";
        ArrayList<Hemisphere> hemispheres = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double radius = rs.getDouble("radius");
                Hemisphere hemisphere = new Hemisphere(ID, radius);
                hemispheres.add(hemisphere);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return hemispheres;
    }

    @Override
    public void insertFigure(double... value) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into hemisphere(ID, radius) values('" + uniqueID + "', '" + value[0] + "');";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public Hemisphere readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM hemisphere where id = '" + selectedIdx + "';";
        Hemisphere hemisphere = new Hemisphere();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double radius = rs.getDouble("radius");
                hemisphere = new Hemisphere(ID, radius);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return hemisphere;
    }
}