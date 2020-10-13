package main.Classes;

import main.DAB.DBUtil;

import javax.sql.rowset.CachedRowSet;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class BlockDAO {

    public static void insertBlock(double length, double width, double height) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into block(ID, length, width, height) values('"+uniqueID+"', '"+length+"', '"+width+"', '"+height+"');";
        try {
            DBUtil.dbExecuteQuery(sql);
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteAllBlocks() throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM Block;";
        try {
            DBUtil.dbExecuteQuery(sql);
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList readAllBlocks() throws SQLException, ClassNotFoundException{
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
}
