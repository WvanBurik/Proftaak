package main.Classes;

import main.DAB.DBUtil;
import main.Interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class SphereDAO implements IDAO {

    public void insertSphere(double radius) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into Sphere(ID, radius) values('" + uniqueID + "', '" + radius + "');";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Sphere where id = '" + selectedIdx + "';";
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
        String sql = "SELECT * FROM Sphere;";
        ArrayList<Sphere> spheres = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double radius = rs.getDouble("radius");
                Sphere sphere = new Sphere(ID, radius);
                spheres.add(sphere);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return spheres;
    }

    public Sphere readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Sphere where id = '" + selectedIdx + "';";
        Sphere returnSphere = new Sphere();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double radius = rs.getDouble("radius");
                Sphere sphere = new Sphere(ID, radius);
                returnSphere = sphere;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return returnSphere;
    }
}