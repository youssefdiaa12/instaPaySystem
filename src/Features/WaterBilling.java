package Features;

public class WaterBilling implements Bill{

            @Override
            public void payBill(double amount) {
                System.out.println("Water Bill Paid");
            }
}
