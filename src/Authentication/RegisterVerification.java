package Authentication;

import DataBase.DbModel;


import java.io.IOException;
import java.util.Scanner;

public class RegisterVerification extends Verification {

    public RegisterVerification(User user, DbModel userDatabase) {
        super(userDatabase);
        this.user = user;

    }

    @Override
    public Boolean Found_in_Db() throws IOException {
        if (DbModel.isUserLoggedIn(user)) {
            // User is already registered and logged in
            System.out.println("This user is already registered.");
            return true;
        } else {
            boolean isFound = otpVerification();
          return   !isFound;

        }
    }
    public boolean otpVerification() {
        String otp = "123456";
        System.out.println("Please enter the OTP sent to your number");
        String userInput = new Scanner(System.in).next();
        if (userInput.equals(otp)) {
            return true;
        }
        else {
            System.out.println("You have entered the wrong OTP.");
            return false;
        }
    }


    public boolean isValidEmail(String email) {
        // Email validation using a simple regular expression
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public boolean isStrongPassword(String password) {
        // Password strength criteria: at least 8 characters, with a mix of uppercase, lowercase, and digits
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }


    public boolean isValidPhoneNumber(String phoneNumber) {
        // Phone number validation: starts with "01" and has a length of 11 digits
        return phoneNumber.matches("01\\d{9}");
    }




}