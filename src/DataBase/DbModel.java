package DataBase;

import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

import Authentication.RegisterUser;
import Authentication.User;

public  class DbModel {
    protected static User user;
  public static DbModel instanceData;
    private static  final Vector<Account>accounts = new Vector<>();

    private static final Vector<User> loggedInUsers = new Vector<>();

    public static boolean isUserLoggedIn(User user) {
        boolean isUserLoggedIn = false;
        for (User loggedInUser : loggedInUsers) {
            if (Objects.equals(user.userName, loggedInUser.userName) && Objects.equals(user.Pass, loggedInUser.Pass)) {
                isUserLoggedIn = true;
                break;
            }
        }

        return isUserLoggedIn;

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






}
