package Features;

import Authentication.User;

public class Transfer {
    TransferStratgy transferStratgy;

    public Transfer(TransferStratgy transferStratgy) {
        this.transferStratgy = transferStratgy;

    }

    public TransferStratgy getTransferStratgy() {
        return transferStratgy;
    }

    public void transferingToInstaWallet( double amount) {
        transferStratgy.transferToInstaPayWallet(amount);

    }

    public void transferingToAnotherWallet(double amount) {
        transferStratgy.transferToAnotherWallet(amount);
    }

    public void transferingToAnotherBank(double amount) {
        if (transferStratgy instanceof BankAccountTransfer) {
            ((BankAccountTransfer) transferStratgy).TransferToBankAccount(amount);
        }
        else{
            System.out.println("You can't transfer to another bank");
        }
    }

}


