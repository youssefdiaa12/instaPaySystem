import Authentication.*;
import DataBase.DbModel;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Do you want to login or register?");
            System.out.println("1-Login");
            System.out.println("2-Register");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
UserAuthentication userAuthentication;
UserAuth_Controller userAuth_Controller=new UserAuth_Controller();
userAuthentication=userAuth_Controller.Descion(choice);
            String userName, password;
            User user = null;
            if (choice == 1) {
                System.out.println("Please enter your UserName");
                userName = input.next();
                System.out.println("Please enter your password");
                password = input.next();
                user = new LoginUser(userName, password);
                userAuthentication.setUser(user);
                if(!userAuthentication.Perform_Authentication()){
                    System.out.println("Login Failed");
                    user=null;
                }

            }
            else if (choice == 2) {
                System.out.println("register with");
                System.out.println("1-wallet account");
                System.out.println("2-bank account");
                int type = input.nextInt();
          UserAccountController userAccountController=new UserAccountController();
                System.out.println("Please enter your UserName");
                userName = input.next();
                System.out.println("Please enter your password");
                password = input.next();
                System.out.println("Please enter your phone number");
                String phoneNumber = input.next();
                System.out.println("Please enter your email");
                String email = input.next();
                user = new RegisterUser(phoneNumber,email,userName, password);
                user.userAcc=userAccountController.accCreator(type,phoneNumber,email,userName,password);
                userAuthentication.setUser(user);
                if (!userAuthentication.Perform_Authentication()) {
                    System.out.println("User registration successful.");
                    // User is successfully registered
                }
                else{
                    user=null;
                }
            } else {
                System.out.println("Please enter a valid choice");
            }

            if(user!=null){
              System.out.println("Welcome "+user.userAcc.userName);
                DbModel.addLoggedInUser(user);
                DbModel.addAccount(user.userAcc);
            }


        }
    }
}