public class User {

    private int userID;
    private String username;
    private String password;
    private int balance;

    public User(int userID,String username, String password, int balance){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public int makeBet(int betSize){
        this.balance = this.balance - betSize;
        DatabaseIO.updateUserBalance(userID, balance);
        return this.balance;
    }

    public int receiveMoney(int money){
        this.balance = this.balance + money;
        DatabaseIO.updateUserBalance(userID, balance);
        return balance;
    }

}