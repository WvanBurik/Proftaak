package main.DAB;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class DBUtil {

    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";

    private static Connection connection = null;

    private static final String connStr = "jdbc:mysql://localhost/proftaak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //Connect database;
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_Driver);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw e;
        }
        System.out.println("---------------");

        try {
            connection = DriverManager.getConnection(connStr, "root", "root");
        }
        catch (SQLException e){
            System.out.println("Connection Failed! Check output Console " + e);
            throw e;
        }
    }

    //Close connection;
    public static void dbDisconnect() throws SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    //To crud records;
    public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        }
        catch(SQLException e) {
            System.out.println("Problem occurred at dbExecuteQuery operation " + e);
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }

    //Retrieve record from DB;
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSet crs = null;

//        try {
//            dbConnect();
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery(sqlQuery);
////            crs = new CachedRowSet();
//            //crs.populate(rs);
//        }
        dbConnect();
        stmt = connection.createStatement();
        rs = stmt.executeQuery(sqlQuery);
        return rs;
//        catch (SQLException e) {
//            System.out.println("Error occurred in dbExecute operation " + e);
//            throw e;
//        }
//        finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            dbDisconnect();
//        }
//        return rs;

    }
}

