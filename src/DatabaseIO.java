import com.mysql.jdbc.jdbc2.optional.JDBC4PreparedStatementWrapper;

import java.sql.*;


public class DatabaseIO {

    public Connection connection;
    private String url = "jdbc:mysql://localhost/ice?" + "autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "cph-nr135";
    public boolean isDatabaseOnline = false;
    public static DatabaseIO databaseIO = new DatabaseIO();

    public DatabaseIO() {
        establishConnection();
    }

    private void closeConnection() {
        try {
            connection.close();
            this.isDatabaseOnline = false;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close connection to database");
        }
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            this.isDatabaseOnline = true;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database");
        }

    }
    public void writeToUserData(String username, String password){
        establishConnection();
        String query = "INSERT INTO ice.userdata (userName, userPassword, userBalance) VALUES (?, ?, 5000)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.execute();
        } catch (SQLException e){
            throw new RuntimeException("Failed to insert new userdata");
        }
        closeConnection();
    }

    public User loadUserData(String username, String password){
        establishConnection();
        String query = "SELECT * FROM ice.userdata WHERE userName = ? AND userPassword = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int ID = resultSet.getInt("idUserData");
                int balance = resultSet.getInt("userBalance");
                User user = new User(ID, username, password, balance);
                closeConnection();
                return user;
            }
        } catch (SQLException e){
            throw new RuntimeException();
        }
        closeConnection();
        return null;
    }

    public void updateUserBalance(int userID, int balance){
        establishConnection();

        closeConnection();
    }
}
