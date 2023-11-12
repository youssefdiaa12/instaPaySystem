package Authentication;

import DataBase.RegisterationDb;


import java.io.IOException;
import java.util.Scanner;

public class RegisterVerification extends Verification {

   public RegisterVerification(User user) {
        this.user = user;
           db = new RegisterationDb((RegisterUser) user);
    }


    @Override
    public Boolean Found_in_Db() throws IOException {
        Boolean is_found = db.readFromFile();
        return is_found;
    }
    public void writeToFile() throws IOException {
       RegisterationDb registerationDb = (RegisterationDb) db;
         registerationDb.writeToFile();
    }

    public Boolean verfyOtp(String otp){
        return otp.equals("123456");
    }

    // Function to check if the email is valid
    public boolean isValidEmail(String email) {
        // Email validation using a simple regular expression
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    // Function to check if the password is strong
    public boolean isStrongPassword(String password) {
        // Password strength criteria: at least 8 characters, with a mix of uppercase, lowercase, and digits
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    // Function to check if the phone number is valid
    public boolean isValidPhoneNumber(String phoneNumber) {
        // Phone number validation: starts with "01" and has a length of 11 digits
        return phoneNumber.startsWith("01") && phoneNumber.length() == 11 && phoneNumber.matches("\\d+");
    }


}