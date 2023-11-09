import Authentication.Login;
import Authentication.Register;
import Authentication.User;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

     while (true){

         System.out.println("Do you want to login or register?");
            System.out.println("1-Login");
            System.out.println("2-Register");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Please enter a valid choice");
                choice = input.nextInt();
            }
            if(choice==1){
                System.out.println("Please enter your UserName");
                String UserName=input.next();
                System.out.println("Please enter your password");
                String password=input.next();
                User user=new User("","",UserName,password);
                user.userAuth=new Login();
                user.userAuth.Perform_Authentication(UserName,password);

            }
            else {
                System.out.println("Please enter your UserName");
                String UserName=input.next();
                System.out.println("Please enter your password");
                String password=input.next();
                System.out.println("Please enter your phone number");
                String phone=input.next();
                System.out.println("Please enter your email");
                String email=input.next();
                User user=new User(phone,email,UserName,password);
                Register register=new Register();
                user.userAuth=register;
                register.Perform_Adv_Authentication(email,password,phone,UserName);



            }



     }


    }
}
