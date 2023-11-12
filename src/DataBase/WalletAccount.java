package DataBase;

import Authentication.User;
import DataBase.Account;

import java.io.*;
import java.util.Objects;

public class WalletAccount extends Account {

     String phoneNumber;

    public WalletAccount(String phoneNum, String email, String userName, String pass) {
        super(phoneNum, email, userName, pass);
    }

    public void setPhoneNumber(String phoneNumber){
      this.phoneNumber=phoneNumber;
  }
    @Override
    public void addAcc(Account account) {
        WalletAccount walletAcc=(WalletAccount) account;
        String filePath="D:\\Projects\\instaPaySystem\\src\\walletAcc.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(walletAcc.userName + " " + walletAcc.Pass + " " + walletAcc.balance + " " + walletAcc.phoneNumber);
            writer.newLine();  // Add a new line after each entry
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }
    public void searchAcc(User user) {
        String filePath = "D:\\Projects\\instaPaySystem\\src\\walletAcc.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name1 = "", pass1 = "", balance1 = "", phoneNum = "";
                int cnt = 0;
                // Process each line of data here
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ' && cnt == 0) {
                        name1 = line.substring(0, i);
                        cnt++;
                    }
                    if (line.charAt(i) == ' ' && cnt == 1) {
                        pass1 = line.substring(name1.length() + 1, i);
                        cnt++;
                    }
                    if (line.charAt(i) == ' ' && cnt == 2) {
                        balance1 = line.substring(name1.length() + pass1.length() + 2, i);
                        cnt++;
                    }
                    if (line.charAt(i) == ' ' && cnt == 3) {
                        phoneNum = line.substring(name1.length() + pass1.length() + balance1.length() + 3, i);
                        cnt++;
                    }

                }
                if (Objects.equals(user.userName, name1)) {
                    user.userAcc.setAccountName(name1);
                    user.userAcc.setPassWord(pass1);
                    user.userAcc.setBalance(Double.parseDouble(balance1));
                    ((WalletAccount) user.userAcc).setPhoneNumber(phoneNum);
                    break;
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }


}
