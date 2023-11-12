package DataBase;

import Authentication.User;
import DataBase.Account;

import java.io.*;
import java.util.Objects;

public class BankAccount extends Account {
    String bankName;
    String bankId;

    public BankAccount(String phoneNum, String email, String userName, String pass) {
        super(phoneNum, email, userName, pass);
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public void addAcc(Account account) {
        BankAccount bankAccount = (BankAccount) account;
        String filePath = "D:\\Projects\\instaPaySystem\\src\\bankAcc.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(bankAccount.userName + " " + bankAccount.Pass + " " + bankAccount.balance + " " + bankAccount.bankName + " " + bankAccount.bankId);
            writer.newLine();  // Add a new line after each entry
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    @Override
    public void searchAcc(User user) {
        String filePath = "D:\\Projects\\instaPaySystem\\src\\bankAcc.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name1 = "", pass1 = "", balance1 = "", bankName1 = "", bankId1 = "";
                int cnt = 0;
                // Process each line of data here
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ' && cnt == 0) {
                        name1 = line.substring(0, i);
                        cnt++;
                    }
                    else if (line.charAt(i) == ' ' && cnt == 1) {
                        pass1 = line.substring(name1.length() + 1, i);
                        cnt++;
                    }
                 else  if (line.charAt(i) == ' ' && cnt == 2) {
                        balance1 = line.substring(name1.length() + pass1.length() + 2, i);
                        cnt++;
                    }
                   else if (line.charAt(i) == ' ' && cnt == 3) {
                        bankName1 = line.substring(name1.length() + pass1.length() + balance1.length() + 3, i);
                        cnt++;
                    }
                   else if (line.charAt(i) == ' ' && cnt == 4) {
                        bankId1 = line.substring(name1.length() + pass1.length() + balance1.length() + bankName1.length() + 4, i);
                        cnt++;

                    }
                }
                if (Objects.equals(user.userAcc.userName, name1)) {
                    user.userAcc.setAccountName(name1);
                    user.userAcc.setPassWord(pass1);
                    user.userAcc.setBalance(Double.parseDouble(balance1));
                    ((BankAccount) user.userAcc).setBankName(bankName1);
                    ((BankAccount) user.userAcc).setBankId(bankId1);
                    break;
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
