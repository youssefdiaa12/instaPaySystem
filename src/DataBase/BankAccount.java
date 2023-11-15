package DataBase;

import Authentication.User;
import DataBase.Account;

import java.io.*;
import java.util.Objects;

public class BankAccount extends Account {
    String bankName;
    String bankId;
    String bankPass;

    public BankAccount(String phoneNum, String email, String userName, String pass) {
        super(phoneNum, email, userName, pass);
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public void setBankPass(String bankPass) {
        this.bankPass = bankPass;
    }
    public String getBankName(){
        return bankName;
    }
    public String getBankId(){
        return bankId;
    }
    public String getBankPass(){
        return bankPass;
    }


}
