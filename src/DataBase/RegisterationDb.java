package DataBase;

import Authentication.RegisterUser;
import Authentication.User;

import java.io.*;
import java.util.Objects;

public class RegisterationDb extends Db {

    public RegisterationDb(RegisterUser user) {
        super(user);
    }

    public Boolean readFromFile() throws IOException {
        Boolean is_found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name1 = "", pass1 = "", phone1 = "", accountType = "";
                // Process each line of data here
                int cnt=0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' '&&cnt==0) {
                            name1 = line.substring(0, i);
                            cnt++;}
                    else if (line.charAt(i) == ' '&&cnt==1) {
                        pass1 = line.substring(0, i);
                        cnt++;
                    }
                    else if (line.charAt(i) == ' '&&cnt==2) {
                        phone1 = line.substring(0, i);
                        cnt++;
                    }
                    else if (line.charAt(i) == ' '&&cnt==3) {
                        cnt++;
                    }
                    else if (line.charAt(i) == ' '&&cnt==4) {
                        accountType = line.substring(0, i);
                        cnt++;
                    }
                }
                String accountType1 = user.userAcc instanceof BankAccount? "BankAccount" : "Wallet";

                if (Objects.equals(user.userName, name1)) {
                    is_found = true;
                    break;
                }

                else if(accountType1.equals(accountType) && Objects.equals(((RegisterUser) user).getPhoneNum(), phone1)){
                    is_found = true;
                    break;
                }
            }
            return is_found;
        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String accountType = user.userAcc instanceof BankAccount? "BankAccount" : "Wallet";
            writer.write(user.userName + " " + user.Pass + " " + ((RegisterUser) user).getPhoneNum() + " " + ((RegisterUser) user).getEmail()+" " +accountType);
            writer.newLine();  // Add a new line after each entry
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }






}



