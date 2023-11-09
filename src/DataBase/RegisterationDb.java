package DataBase;

import Authentication.User;

import java.io.*;
import java.util.Objects;

public class RegisterationDb extends Db {

String filePath = "D:\\Projects\\instaPaySystem\\src\\DataBase\\Clients.txt";
String phone;
String email;
String name;
String password;
    public RegisterationDb(String name, String password, String phone, String email) {
        super(name, password);
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.password = password;
        user.phoneNum = phone;
        user.Email = email;
    }



    public Boolean readFromFile() throws IOException {
        Boolean is_found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name1 = "", phone1 = "", password1 = "", email1 = "";
                // Process each line of data here
                int cnt = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        if (cnt == 0) {
                            name1 = line.substring(0, i);
                            cnt++;
                        } else if (cnt == 1) {
                            password1 = line.substring(0, i);
                            cnt++;
                        } else if (cnt == 2) {
                            phone1 = line.substring(0, i);
                            cnt++;
                        } else {
                            email1 = line.substring(0, i);

                            cnt++;
                        }
                    }

                }
                if (Objects.equals(user.userName, name1)) {
                    is_found = true;
                    break;
                }
            }
            return is_found;
        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.userName + " " + user.Pass + " " + user.phoneNum + " " + user.Email);
            writer.newLine();  // Add a new line after each entry
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }






}



