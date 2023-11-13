package Features;

import Authentication.User;
import DataBase.DbModel;

import java.util.Scanner;

public abstract class TransferStratgy {
    User user;
    DbModel dbModel;

    TransferStratgy(User user, DbModel dbModel) {
        this.user = user;
        this.dbModel = dbModel;
    }


    public void transferToInstaPayWallet(double amount) {
        if (user.userAcc.getBalance() >= amount) {
            if (amount > 0) {
                System.out.println("Pleae enter the phone number of the wallet you want to transfer to");
                Scanner input = new Scanner(System.in);
                String phoneNumber = input.next();
                if(dbModel.isFoundInstaPayAccount(phoneNumber,amount))
                {
                    user.userAcc.setBalance(user.userAcc.getBalance() - amount);
                    System.out.println("Transfered to wallet successfully");
                }
                else{
                    System.out.println("This phone number is not registered in InstaPay");
                }
            } else {
                System.out.println("Invalid amount");
            }
        } else {
            System.out.println("You don't have enough balance");
        }
    }

    ;

    public void transferToAnotherWallet(double amount) {
        if (user.userAcc.getBalance() >= amount) {
            if (amount > 0) {
                System.out.println("pleae enter the phone number of the wallet you want to transfer to");
                Scanner input = new Scanner(System.in);
                String phoneNumber = input.next();
                user.userAcc.setBalance(user.userAcc.getBalance() - amount);
                System.out.println("Transfered to another wallet successfully");
            } else {
                System.out.println("Invalid amount");
            }
        } else {
            System.out.println("You don't have enough balance");
        }
    }

    ;
}


