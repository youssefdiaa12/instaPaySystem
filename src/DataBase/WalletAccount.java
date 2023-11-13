package DataBase;

import Authentication.User;
import DataBase.Account;

import java.io.*;
import java.util.Objects;

public class WalletAccount extends Account {

     String phoneNumber;

    public WalletAccount(String phoneNum, String email, String userName, String pass) {
        super(phoneNum, email, userName, pass);
    }

    public void setPhoneNumber(String phoneNumber){
      this.phoneNumber=phoneNumber;
  }

}
