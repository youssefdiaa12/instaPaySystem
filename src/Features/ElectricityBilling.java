package Features;

public class ElectricityBilling extends Bill {

    @Override
    public void payBill(double amount) {
        System.out.println("Electricity Bill Paid");
    }
}
