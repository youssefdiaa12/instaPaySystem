public class Register extends RegisterAuth{

    @Override
    public void Perform_Adv_Authentication(String email, String password, String phoneNumber, String userName) {
        Perform_Authentication(email,password);
        verification= new RegisterVerification(email,phoneNumber,userName,password);
    }
}
