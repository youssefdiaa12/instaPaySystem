import Authentication.*;
import DataBase.BankAccount;
import DataBase.Db;
import DataBase.WalletAccount;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        while (true) {

            System.out.println("Do you want to login or register?");
            System.out.println("1-Login");
            System.out.println("2-Register");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            UserAuth_Controller userAuth_Controller = new UserAuth_Controller();
            UserAuthentication userAuthentication = userAuth_Controller.Descion(choice);
            String UserName = "", password = "";
            User user = null;
            if (choice == 1) {
                System.out.println("Please enter your UserName");
                 UserName = input.next();
                System.out.println("Please enter your password");
                 password = input.next();
                user = new LoginUser(UserName, password);
                userAuthentication.setUser(user);
                user.userAuth = userAuthentication;
                user.userAuth.Perform_Authentication();
            }
            else if (choice == 2) {
                System.out.println("Register With");
                System.out.println("1-Bank Account");
                System.out.println("2-Wallet Account");
                int choice2 = input.nextInt();
                System.out.println("Please enter your UserName");
                 UserName = input.next();
                System.out.println("Please enter your password");
                 password = input.next();
                System.out.println("Please enter your phone number");
                String phone = input.next();
                System.out.println("Please enter your Email");
                String Email = input.next();
                user = new RegisterUser(phone, Email, UserName, password);
            user.userAuth = userAuthentication;
               user.userAuth.setUser(user);
                UserAccountController userAccountController = new UserAccountController();
              user.userAcc=userAccountController.accCreator(choice2, phone, Email, UserName, password);
                if (user.userAcc instanceof BankAccount) {
                    System.out.println("Please enter your Bank Name");
                    String BankName = input.next();
                    System.out.println("Please enter your Bank ID");
                    String BankID = input.next();
                    ((BankAccount) user.userAcc).setBankName(BankName);
                    ((BankAccount) user.userAcc).setBankId(BankID);
                }
                if (user.userAcc instanceof WalletAccount) {
                    ((WalletAccount) user.userAcc).setPhoneNumber(phone);
                }
                user.userAuth.Perform_Authentication();


            } else {
                System.out.println("Please enter a valid choice");
            }
            if (user.userAuth instanceof Register) {
                user.userAcc.setBalance(0);
                user.userAcc.addAcc(user.userAcc);
                user=new LoginUser(UserName,password);
                user.userAcc.searchAcc(user);
            } else {
                user.userAcc.searchAcc(user);

            }
        }
    }
}

