package project.csc207;

import java.io.Serializable;
import java.util.HashMap;

public class AccountManager implements Serializable {
    /*
   All accounts with key account Id and variable Account
    */
    private HashMap<String, Account> allAccount;

    private Account currentAccount;

    AccountManager(){
        this.currentAccount = null;
        this.allAccount = null;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
    void hasAllAccount(){
        if(allAccount == null){
            setAllAccount( new HashMap<>());
        }
    }
    void setCurrentAccount(String id) {

        this.currentAccount = allAccount.get(id);
    }
    boolean notNewUser(String id){
        return  this.allAccount.containsKey(id);
    }
    public void updateAccount(){
        allAccount.put(currentAccount.getUserName(), currentAccount);
    }
    boolean rightPassword(String id, String password){
        return this.allAccount.get(id).getPassword().equals(password);
    }

    void signUp(String id, String password){
        this.allAccount.put(id, new Account(id, password));
    }

    void setAllAccount(HashMap hashMap){
        this.allAccount = hashMap;
    }
}
