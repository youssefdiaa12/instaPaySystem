package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import Authentication.User;

public abstract class Db {

    //Note: This path is for my computer, you should change it to your own path
    String filePath = "D:\\Projects\\instaPaySystem\\src\\Clients.txt";
   public User user;
    public Db(User user) {
        this.user = user;

    }
    public abstract Boolean readFromFile() throws IOException;



}