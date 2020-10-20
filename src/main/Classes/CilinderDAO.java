package main.Classes;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import main.DAB.DBUtil;
import sample.Main;

import javax.sql.rowset.CachedRowSet;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class CilinderDAO {

    public static void insertCilinder(double height, double radius) throws SQLException, ClassNotFoundException {
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

    public static void deleteAllCilinders() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Cilinder;";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteCilinder(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Cilinder where ID = '" + selectedIdx + "';";

        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList readAllCilinders() throws SQLException, ClassNotFoundException {
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

}