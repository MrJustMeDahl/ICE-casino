
import java.security.PrivateKey;
import java.sql.*;


public class DatabaseIO {

    public Connection connection;
    private String url = "jdbc:mysql://localhost/ice?" + "autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "030389";
    public boolean isDatabaseOnline = false;

    public DatabaseIO() {
        establishConnection();
    }

    public void closeConnection() {
        try {
            connection.close();
            this.isDatabaseOnline = false;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            this.isDatabaseOnline = true;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
    private void writeToUserData(String path){
        establishConnection();


    }
}
