public class User {

    private int userID;
    private String username;
    private String password;
    private float balance;

    public User(int userID,String username, String password, float balance){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public float makeBet(float betSize){
        this.balance = this.balance - betSize;
        DatabaseIO.databaseIO.updateUserBalance(userID, balance);
        return this.balance;
    }

    public float receiveMoney(float money){
        this.balance = this.balance + money;
        DatabaseIO.databaseIO.updateUserBalance(userID, balance);
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public float getBalance() {
        return balance;
    }
}