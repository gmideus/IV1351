package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAccess {

    private static final DBAccess DBACCESS = new DBAccess();
    private Connection connection;
    private String URL = "jdbc:mysql:///iv1351?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userID = "root";
    private String password = "root";

    public static DBAccess getDBAccess() {
        return DBAccess.DBACCESS;
    }

    public void connect() throws Exception {
        Class.forName(driver);
        this.connection = DriverManager.getConnection(URL, userID, password);
        this.connection.setAutoCommit(false);
    }

    public Connection getDBConnection() {
        return this.connection;
    }

    public static void main(String[] args) {
        try {
        DBAccess db = DBAccess.getDBAccess();
        db.connect();
        Connection connection = db.getDBConnection();
        String query = "SELECT marke FROM bil GROUP BY marke";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("Alla bilmärken i databasen: ");

        while (rs.next()) {
            System.out.println(rs.getString("marke"));
        }

        stmt.close();
        connection.close();
        } catch(Exception exc) {
            exc.printStackTrace();
        }

    }

}
