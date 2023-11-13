package Authentication;

import Authentication.UserAuthentication;
import DataBase.Account;

public abstract class User {
   public Account userAcc;
    public  String userName;
    public  String Pass;



    public User(String userName, String pass) {

        this.userName = userName;
        this.Pass=pass;
    }
    public void setAccountName(String AccountName){
        this.userName=AccountName;
    }
    public void setPassWord(String PassWord){
        this.Pass=PassWord;
    }

    public String getUserName(){
        return userName;
    }
    public String getPass(){
        return Pass;
    }

}
