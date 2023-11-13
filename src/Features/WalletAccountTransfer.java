package Features;

import Authentication.User;
import DataBase.DbModel;

public class WalletAccountTransfer extends TransferStratgy{
    public WalletAccountTransfer(User user, DbModel userDatabase) {
        super(user,userDatabase);
    }
}
