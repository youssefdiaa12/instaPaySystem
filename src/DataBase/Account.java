package DataBase;

import Authentication.User;

public abstract class Account {
    public   String phoneNum;
    public String Email;
    public  String userName;
    public  String Pass;
    double balance;
    public Account(String phoneNum, String email, String userName, String pass) {
        this.phoneNum = phoneNum;
        this.Email = email;
        this.userName = userName;
        this.Pass=pass;
    }
   public void setAccountName(String AccountName){
        this.userName=AccountName;
    }
   public void setPassWord(String PassWord){
        this.Pass=PassWord;
    }
    public void setBalance(double balance){
          this.balance=balance;
     }
    public abstract void addAcc(Account account);
   public abstract void searchAcc(User user);
}
