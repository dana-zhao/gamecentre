package project.csc207;

public class Account {

    /*
    The account currently logged in.
     */
    static Account currentAccount;

    /*
    The score for the current account.
     */
    private double score = 0;

    /*
    The username of the account currently logged in.
     */
    private String userName;

    /*
    The password of the account currently logged in.
     */
    private String password;

    /*
    Create a new account.
     */
    Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    /*
    Return the current account's username.
     */
    public String getUserName() {
        return userName;
    }

    /*
    Return the score for the current user.
     */
    public double getScore() {
        return score;
    }

    /**
     * Return the current account.
     */
    public static Account getCurrentAccount() {
        return currentAccount;
    }
}