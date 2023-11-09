package Authentication;

import Authentication.UserAuthentication;
import DataBase.Account;

public class User {
    public UserAuthentication userAuth;
    Account userAcc;
  public   String phoneNum;
    public String Email;
    public  String userName;
    public  String Pass;

    public User(String phoneNum, String email, String userName, String pass) {
        this.phoneNum = phoneNum;
        Email = email;
        this.userName = userName;
        this.Pass=pass;
    }

}
