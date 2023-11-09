package DataBase;

import Authentication.User;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoginDB extends Db{
    public LoginDB(String name, String password) {
        super(name, password);
    }

    public Boolean user_exist() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
               if (data[0].equals(user.userName) && data[1].equals(user.Pass)) {

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
