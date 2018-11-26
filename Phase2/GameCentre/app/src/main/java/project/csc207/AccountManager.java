package project.csc207;

import java.io.Serializable;
import java.util.HashMap;

public class AccountManager implements Serializable {
    /**
   All accounts with key account Id and variable Account
    */
    private HashMap<String, Account> allAccount;

    private Account currentAccount;

    AccountManager(){
        this.currentAccount = null;
        this.allAccount = null;
    }
    /**
     Return allAccount
     */
    public Account getCurrentAccount() {
        return currentAccount;
    }
    /**
     Return allAccount
     */
    public HashMap<String, Account> getAllAccount() {
        return allAccount;
    }

    /**
     Set allAccount
     */
    void setCurrentAccount(String id) {

        this.currentAccount = allAccount.get(id);
    }
    /**
     Return true if user id has been used
     */
    boolean notNewUser(String id){
        return  this.allAccount.containsKey(id);
    }
    /**
     Update current account information to allAccount
     */
    public void updateAccount(){
        allAccount.put(currentAccount.getUserName(), currentAccount);
    }
    /**
     Return true if the password is correct for indexing user id
     */
    boolean rightPassword(String id, String password){
        return this.allAccount.get(id).getPassword().equals(password);
    }
    /**
     Set a new user and add it to allAccount
     */
    void signUp(String id, String password){
        this.allAccount.put(id, new Account(id, password));
    }
    /**
     Set  allAccount
     */
    void setAllAccount(HashMap hashMap){
        this.allAccount = hashMap;
    }
}
