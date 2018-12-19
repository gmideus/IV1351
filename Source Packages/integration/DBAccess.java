package integration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class holds all the information needed to connect to the database and
 * also has the functionality to set up and return the database connection.
 *
 */
public class DBAccess {

    private static final DBAccess DBACCESS = new DBAccess();
    private Connection connection;
    private String URL = "jdbc:mysql:///iv1351?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userID = "iv1351";
    private String password = "password";

    /**
     * @return the instance of this class.
     */
    public static DBAccess getDBAccess() {
        return DBAccess.DBACCESS;
    }

    /**
     * Connects to the database with the information in the instance variables and
     * sets up a commit configuration.
     * 
     * @throws Exception if failed to connect to the database.
     */
    public void connect() throws Exception {
        Class.forName(driver);
        this.connection = DriverManager.getConnection(URL, userID, password);
        this.connection.setAutoCommit(false);
    }

    /**
     * @return The {@link Connection} to the database. The {@code connect} method
     *         should be called before this method, preferably in the {@link Startup}.
     */
    public Connection getDBConnection() {
        return this.connection;
    }

}
