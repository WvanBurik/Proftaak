package main.Classes;

        import main.DAB.DBUtil;

        import javax.sql.rowset.CachedRowSet;
        import javax.xml.transform.Result;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.UUID;

public class PyramidDAO {

    public static void insertPyramid(double height, double baseLength) throws SQLException, ClassNotFoundException {
        String uniqueID = UUID.randomUUID().toString();
        String sql = "insert into Pyramid(ID, height, baseLength) values('" + uniqueID + "', '" + height + "', '" + baseLength + "');";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteAllPyramids() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Pyramid;";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList readAllPyramids() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Pyramid;";
        ArrayList<Pyramid> pyramids = new ArrayList<>();

        try {
            ResultSet rs = DBUtil.dbExecute(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                double height = rs.getDouble("height");
                double baseLength = rs.getDouble("baseLength");
                Pyramid pyramid = new Pyramid(height, baseLength);
                pyramids.add(pyramid);
            }
        } catch (SQLException e) {
            System.out.println("Exception occur while inserting the data " + e);
            e.printStackTrace();
            throw e;
        }
        return pyramids;
    }
}