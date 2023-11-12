package Authentication;

import Authentication.Verification;
import DataBase.Db;
import DataBase.LoginDB;

import java.io.IOException;

public class LoginVerification extends Verification {

    public LoginVerification(User user) {
        this.user = user;
        db = new LoginDB(user);
    }

    @Override
    public Boolean Found_in_Db() throws IOException {
        Boolean is_found = db.readFromFile();
        return is_found;
    }
}
