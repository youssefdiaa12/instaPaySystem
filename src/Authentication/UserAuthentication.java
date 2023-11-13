package Authentication;

import DataBase.DbModel;

import java.io.IOException;

public abstract class UserAuthentication {
    User user;
    DbModel dbModel;
   public Verification verification;
    public void setUser(User user) {
        this.user = user;
    }
    public abstract Boolean Perform_Authentication() throws IOException;



}
