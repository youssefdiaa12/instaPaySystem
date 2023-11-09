package Authentication;
import DataBase.RegisterationDb;


import java.io.IOException;
import java.util.Scanner;

public class RegisterVerification implements Verification {

    RegisterVerification(String email,String phoneNumber,String userName,String password) throws IOException {
        RegisterationDb db = new RegisterationDb(userName,password,phoneNumber,email);
       Boolean is_found= db.readFromFile();
        if(is_found){
            System.out.println("This user is already registered");
        }
        else{
           String otp="123456";
           System.out.println("Please enter the OTP sent to your number");
           String user_input= new Scanner(System.in).next();
           if(user_input.equals(otp)){
                System.out.println("You are successfully registered");
                db.writeToFile();
           }
              else{
                System.out.println("You have entered wrong OTP");
              }
        }


    }
}
