package main.Classes;

import main.DAB.DBUtil;
import main.Interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class PyramidDAO implements IDAO {

    @Override
    public void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Pyramid where id = '" + selectedIdx + "';";
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
        String sql = "SELECT * FROM Pyramid;";
        ArrayList<Pyramid> pyramids = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double height = rs.getDouble("height");
                double baseLength = rs.getDouble("baseLength");
                Pyramid pyramid = new Pyramid(ID, height, baseLength);
                pyramids.add(pyramid);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return pyramids;
    }

    @Override
    public void insertFigure(double... value) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into Pyramid(ID, height, baseLength) values('" + uniqueID + "', '" + value[0] + "', '" + value[1] + "');";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public Pyramid readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Pyramid where id = '" + selectedIdx + "';";
        Pyramid pyramid = new Pyramid();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double height = rs.getDouble("height");
                double baseLength = rs.getDouble("baseLength");
                pyramid = new Pyramid(ID, height, baseLength);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return pyramid;
    }
}