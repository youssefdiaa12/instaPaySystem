package DataBase;

import Authentication.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LoginDB extends Db {
    public LoginDB(User user) {
        super(user);
        this.user = user;
    }


    @Override
    public Boolean readFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].equals(user.getUserName()) && data[1].equals(user.getPass())) {
                    if(Objects.equals(data[4], "BankAccount"))
                        user.userAcc = new BankAccount(data[2], data[3], data[0], data[1]);
                    else
                        user.userAcc = new WalletAccount(data[2], data[3], data[0], data[1]);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }


}
