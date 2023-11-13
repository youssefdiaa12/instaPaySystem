package Authentication;

import DataBase.DbModel;

import java.io.IOException;

public abstract class Verification {
   public DbModel dbModel;
    public User user;
    public abstract Boolean Found_in_Db() throws IOException;

    public Verification(DbModel userDatabase) {
        this.dbModel = userDatabase;
    }

}
