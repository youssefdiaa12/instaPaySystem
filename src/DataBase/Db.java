package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import Authentication.User;

public abstract class Db {
    String name, password;
   public User user;
    public Db(String name, String password) {
        this.name = name;
        this.password = password;
        user = new User("","", name, password);
    }


    String filePath = "D:\\Projects\\instaPaySystem\\src\\DataBase\\Clients.txt";

    public void main(String[] args) {
        // Example usage: Read data from a file


    }


}