package Authentication;

import java.io.IOException;

public abstract class UserAuthentication {
    User user;
   public Verification verification;
    public void setUser(User user) {
        this.user = user;
    }
    public abstract Boolean Perform_Authentication() throws IOException;



}
