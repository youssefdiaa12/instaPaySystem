package Features;

public class GasBilling extends Bill{

        @Override
        public void payBill(double amount) {
            System.out.println("Gas Bill Paid");
        }
}
