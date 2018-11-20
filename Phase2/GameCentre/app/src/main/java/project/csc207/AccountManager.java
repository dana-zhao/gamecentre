package project.csc207;

import java.io.Serializable;
import java.util.HashMap;

public class AccountManager implements Serializable {
    /*
   All accounts with key account Id and variable Account
    */
    private static HashMap<String, Account> allAccount = new HashMap<String, Account>();

    private Account currentAccount;

    Account getCurrentAccount() {
        return currentAccount;
    }

    void setCurrentAccount(String id) {
        this.currentAccount = allAccount.get(id);
    }
    boolean notNewUser(String id){
        return  allAccount.containsKey(id);
    }
    boolean rightPassword(String id, String password){
        return allAccount.get(id).getPassword().equals(password);
    }

    void signUp(String id, String password){
        allAccount.put(id, new Account(id, password));
    }
}
