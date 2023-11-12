package Authentication;

import java.io.IOException;
public class UserAuth_Controller {

        public UserAuth_Controller(){};
    public UserAuthentication Descion(int type) throws IOException {

        if (type==1) {
            return new Login();
        } else {
            return new Register();
        }
    }






}
