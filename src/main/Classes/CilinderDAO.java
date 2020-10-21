package main.Classes;

import main.DAB.DBUtil;
import main.Interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class CilinderDAO implements IDAO {

    public void insertCilinder(double height, double radius) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into cilinder(ID, height, radius) values('" + uniqueID + "', '" + height + "', '" + radius + "');";
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
        String sql = "DELETE FROM Cilinder where ID = '" + selectedIdx + "';";

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
        String sql = "SELECT * FROM Cilinder;";
        ArrayList<Cilinder> cilinders = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double height = rs.getDouble("height");
                double radius = rs.getDouble("radius");
                Cilinder cilinder = new Cilinder(ID, height, radius);
                cilinders.add(cilinder);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return cilinders;
    }

    public Cilinder readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Cilinder where ID = '" + selectedIdx + "';";
        Cilinder cilinder = new Cilinder();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double height = rs.getDouble("height");
                double radius = rs.getDouble("radius");
                cilinder = new Cilinder(ID, height, radius);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return cilinder;
    }
}