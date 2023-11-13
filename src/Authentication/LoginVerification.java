package Authentication;
import DataBase.DbModel;


import java.io.IOException;

public class LoginVerification extends Verification {

    public LoginVerification(User user, DbModel userDatabase) {
        super(userDatabase);
        this.user = user;
    }

    @Override
    public Boolean Found_in_Db() throws IOException {
        // User is logged in, perform any additional checks if needed
        // ...
        // User is not logged in
        if(DbModel.isUserLoggedIn(user)){
           user.userAcc= DbModel.getAccountByName(user.getUserName());
            return true;
        }

        return DbModel.isUserLoggedIn(user);
    }
}

