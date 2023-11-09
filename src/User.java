public class User {
    UserAuthentication userAuth;
    Account userAcc;
    String phoneNum;
    String Email;
    String userName;
    String Pass;

    public User(String phoneNum, String email, String userName, String pass) {
        this.phoneNum = phoneNum;
        Email = email;
        this.userName = userName;
        this.Pass=pass;
    }

}
