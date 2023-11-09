public class UserAuth_Controller {
    UserAuthentication userAuth;
    public UserAuthentication Descion(Boolean type){
        if (type) {
            return new Login();
        } else if (!(type)) {
            return new Register();
        }
        return null;

    }
}
