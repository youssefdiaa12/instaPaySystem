package DataBase;

import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

import Authentication.RegisterUser;
import Authentication.User;

public  class DbModel {
    protected static DbModel dbModel;
    protected static User user;
    private static  final Vector<Account>accounts = new Vector<>();

    private static final Vector<User> loggedInUsers = new Vector<>();

    public static boolean isUserLoggedIn(User user) {
        boolean isUserLoggedIn = false;
        for (User loggedInUser : loggedInUsers) {
            if (Objects.equals(user.userName, loggedInUser.userName)) {
                isUserLoggedIn = true;
                break;
            }
            else if(user.userAcc instanceof  BankAccount  && loggedInUser.userAcc instanceof BankAccount && Objects.equals(user.userAcc.phoneNum, loggedInUser.userAcc.phoneNum)){
                isUserLoggedIn = true;
                break;
            }
            else if(user.userAcc instanceof  WalletAccount  && loggedInUser.userAcc instanceof WalletAccount && Objects.equals(user.userAcc.phoneNum, loggedInUser.userAcc.phoneNum)){
                isUserLoggedIn = true;
                break;
            }
        }

        return isUserLoggedIn;

    }

    public boolean isFoundInstaPayAccount(String number,double amount){

        for (Account account : accounts) {
            System.out.println(account.phoneNum);
            if (Objects.equals(account.phoneNum, number) &&account instanceof WalletAccount) {
                account.setBalance(account.getBalance()+amount);
                return true;
            }
        }
        return false;

    }

    public static Account getAccountByName(String name){
        for (Account account : accounts) {
            if (Objects.equals(account.getUserName(), name)) {
                return account;
            }
        }
        return null;
    }

    public static void addLoggedInUser(User user) {
        loggedInUsers.add(user);
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

public static DbModel getInstance(){
    if(dbModel==null){
        dbModel=new DbModel();
    }
    return dbModel;
}




}
