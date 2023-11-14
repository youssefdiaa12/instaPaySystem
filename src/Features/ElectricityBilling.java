package Features;

public class ElectricityBilling implements Bill {

    @Override
    public void payBill(double amount) {
        System.out.println("Electricity Bill Paid");
    }
}
