package Authentication;

import java.util.Scanner;

public class Register extends UserAuthentication {

    @Override
    public Boolean Perform_Authentication() {
        try {

            RegisterVerification registerVerification= new RegisterVerification(user);
            verification=registerVerification;
            while(registerVerification.Found_in_Db()){
                System.out.println("This user is already registered");
                System.out.println("please make sure that your data not used before or try to login");
                String user_input = new Scanner(System.in).next();
                user.setAccountName(user_input);
            }
            while (!registerVerification.isValidEmail(((RegisterUser) user).getEmail())) {
                System.out.println("Please enter a valid email");
                String email = new Scanner(System.in).next();
                ((RegisterUser) user).setEmail(email);
            }
           while (!registerVerification.isStrongPassword(user.getPass())){
                System.out.println("Please enter a valid password");
                String pass = new Scanner(System.in).next();
                user.setPassWord(pass);
            }
            while (!registerVerification.isValidPhoneNumber(((RegisterUser) user).getPhoneNum())){
                System.out.println("Please enter a valid phone number");
                String phoneNum = new Scanner(System.in).next();
                ((RegisterUser) user).setPhoneNum(phoneNum);
            }

                System.out.println("Please enter the OTP sent to your number");
                String user_input = new Scanner(System.in).next();
                if (registerVerification.verfyOtp(user_input)) {
                    registerVerification.writeToFile();
                    System.out.println("You are successfully registered");
                    return true;

                } else {
                    System.out.println("You have entered wrong OTP");
                    return false;
                }


        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("An error occurred");
        }
        return false;
    }

}