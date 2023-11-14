package Features;

import Authentication.User;

public class BillingSystem {
    User user;
    Bill bill;

    public BillingSystem(User user, Bill bill) {
        this.user=user;
        this.bill=bill;
    }

    public void payBill(double amount){
        if(user.userAcc.getBalance()>=amount){
            user.userAcc.setBalance(user.userAcc.getBalance()-amount);
            bill.payBill(amount);
        }
        else{
            System.out.println("Insufficient Balance");
        }

    }

}
