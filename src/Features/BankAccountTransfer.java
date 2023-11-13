package Features;

import Authentication.User;
import DataBase.DbModel;

public class BankAccountTransfer extends TransferStratgy{


    public BankAccountTransfer(User user, DbModel userDatabase) {
        super(user, userDatabase);
    }

    public void TransferToBankAccount(double amount){
        if(user.userAcc.getBalance()>=amount) {
            if (amount > 0) {
                user.userAcc.setBalance(user.userAcc.getBalance() - amount);
                System.out.println("Transfered to bank account successfully");
            } else {
                System.out.println("Invalid amount");
            }
        }
        else{
            System.out.println("You don't have enough balance");
        }
    }

}
