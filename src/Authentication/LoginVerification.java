package Authentication;

import Authentication.Verification;
import DataBase.Db;
import DataBase.LoginDB;

public class LoginVerification implements Verification {
    public Boolean isValid(String email,String password){

        Db db = new LoginDB(email,password);

        return null;
    }
}
