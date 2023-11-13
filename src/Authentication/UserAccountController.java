package Authentication;

import DataBase.Account;
import DataBase.BankAccount;
import DataBase.WalletAccount;

public class UserAccountController {

    Account acc;

    public Account accCreator(int choice,String phoneNum, String email, String userName, String pass) {
        if (choice == 1) {
            acc = new WalletAccount(phoneNum, email, userName, pass);
        } else if (choice == 2) {
            acc = new BankAccount(phoneNum, email, userName, pass);
        }

        return acc;
    }
}