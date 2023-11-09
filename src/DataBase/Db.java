package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import Authentication.User;

public abstract class Db {
    String name, password;
    //Note: This path is for my computer, you should change it to your own path
    String filePath = "C:\\Users\\DELL\\Documents\\GitHub\\instaPaySystem\\src\\Clients.txt";
   public User user;
    public Db(String name, String password) {
        this.name = name;
        this.password = password;
        user = new User("","", name, password);
    }




    public void main(String[] args) {
        // Example usage: Read data from a file


    }


}