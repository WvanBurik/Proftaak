package main.Classes;

import main.DAB.DBUtil;

import java.sql.SQLException;

public class BlockDAO {

    public static void insertBlock(double length, double width, double height) throws SQLException, ClassNotFoundException {
        String sql = "insert into block(length, width, height) values('"+length+"', '"+width+"', '"+height+"');";
        try {
            DBUtil.dbExecuteQuery(sql);
        }
        catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
