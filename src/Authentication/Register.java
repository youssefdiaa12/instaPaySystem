package Authentication;

import DataBase.BankAccount;
import DataBase.DbModel;

import java.util.Scanner;

public class Register extends UserAuthentication {

    @Override
    public Boolean Perform_Authentication() {
        try {

            RegisterVerification registerVerification= new RegisterVerification(user,dbModel);
            verification=registerVerification;
            if(user.userAcc instanceof BankAccount){
              if(!bankApi.isAccountValid(((BankAccount) user.userAcc).getBankName(),((BankAccount) user.userAcc).getBankId(),((BankAccount) user.userAcc).getUserName(),((BankAccount) user.userAcc).getPass())){
             System.out.println("this Bank Account not found");
              return false;
              }
            }
            if(registerVerification.Found_in_Db()){
                System.out.println("This username is already taken");
           return false;
            }
            if(!registerVerification.otpVerification()){
                return false;
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


        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("An error occurred");
        }
        return true;
    }

}