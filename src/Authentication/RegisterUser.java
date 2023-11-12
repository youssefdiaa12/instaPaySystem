package Authentication;

public class RegisterUser extends User {

    String phoneNum;
    String email;

    public RegisterUser(String phoneNum, String email, String userName, String pass) {
        super(userName, pass);
        this.phoneNum = phoneNum;
        this.email = email;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum=phoneNum;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getEmail(){
        return email;
    }
}
