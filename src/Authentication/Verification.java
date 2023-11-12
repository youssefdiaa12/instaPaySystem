package Authentication;

import DataBase.Db;

import java.io.IOException;

public abstract class Verification {
   public Db db;
    public User user;
    public abstract Boolean Found_in_Db() throws IOException;


}
