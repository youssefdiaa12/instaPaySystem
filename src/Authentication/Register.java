package Authentication;

import java.io.IOException;

public class Register extends RegisterAuth {


    @Override
    public void Perform_Adv_Authentication(String email, String password, String phoneNumber, String userName) {
        Perform_Authentication(email, password);
        try {
            verification = new RegisterVerification(email, phoneNumber, userName, password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
