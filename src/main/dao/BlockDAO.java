package main.dao;

import main.DAB.DBUtil;
import main.classes.Block;
import main.interfaces.FigureInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class BlockDAO implements FigureInterface {

    @Override
    public void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Block where ID = '" + selectedIdx + "';";
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
        String sql = "SELECT * FROM Block;";
        ArrayList<Block> blocks = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                double height = rs.getDouble("height");
                Block block = new Block(ID, length, width, height);
                blocks.add(block);
            }
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return blocks;
    }

    @Override
    public void insertFigure(double... value) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into block(ID, length, width, height) values('"+uniqueID+"', '"+ value[0] +"', '"+ value[1] +"', '"+ value[2] +"');";
        try {
            DBUtil.dbExecuteQuery(sql);
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public Block readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Block where ID = '" + selectedIdx + "';";
        Block block = new Block();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double length = rs.getDouble("length");
                double width = rs.getDouble("width");
                double height = rs.getDouble("height");
                block = new Block(ID, length, width, height);
            }
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return block;
    }

}
