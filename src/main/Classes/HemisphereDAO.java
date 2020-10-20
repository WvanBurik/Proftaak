package main.Classes;

import main.DAB.DBUtil;

import javax.sql.rowset.CachedRowSet;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class HemisphereDAO {

    public static void insertHemisphere(double radius) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into hemisphere(ID, radius) values('" + uniqueID + "', '" + radius + "');";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteAllHemispheres() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM hemisphere;";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteHemisphere(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM hemisphere where id = '" + selectedIdx + "';";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList readAllHemispheres() throws SQLException, ClassNotFoundException {
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


}