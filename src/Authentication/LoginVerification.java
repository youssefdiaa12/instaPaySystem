package Authentication;

import Authentication.Verification;
import DataBase.Db;
import DataBase.LoginDB;

public class LoginVerification implements Verification {

    LoginVerification(String userName, String password) {
        LoginDB db = new LoginDB(userName, password);
        Boolean is_found = db.user_exist();
        if (is_found) {
            System.out.println("You are successfully logged in");
        } else {
            System.out.println("You are not registered in our system");
        }
    }
}
