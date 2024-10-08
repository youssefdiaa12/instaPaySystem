package Authentication;

import java.io.IOException;

public class Login extends UserAuthentication {


    @Override
    public Boolean Perform_Authentication() throws IOException {

        LoginVerification loginVerification = new LoginVerification(user,dbModel);
        verification=loginVerification;
        if (loginVerification.Found_in_Db()) {
            System.out.println("Login Successful");
            return true;
        }
        else{
            return false;
        }
    }
}
