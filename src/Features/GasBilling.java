package Features;

public class GasBilling implements Bill{

        @Override
        public void payBill(double amount) {
            System.out.println("Gas Bill Paid");
        }
}
