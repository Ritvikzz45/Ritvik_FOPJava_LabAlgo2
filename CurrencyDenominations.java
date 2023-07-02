package lab2;
import java.util.*;

public class CurrencyDenominations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of currency denominations: ");
        int n = input.nextInt();

        int[] denominations = new int[n];
        System.out.print("Enter the currency denominations value: ");
        for (int i = 0; i < n; i++) {
            denominations[i] = input.nextInt();
        }

        System.out.print("Enter the amount you want to pay: ");
        int amount = input.nextInt();

        Arrays.sort(denominations);  // sort the denominations in ascending order

        int[] payment = new int[n]; // use an array to store the payment approach

        for (int i = n-1; i >= 0; i--) {
            int count = amount / denominations[i];

            if (count > 0) {
                payment[i] = count;
                amount -= count * denominations[i];
            }
        }

        System.out.println("Your payment approach in order to give min no of notes will be:");
        for (int i = n-1; i >= 0; i--) {
            if (payment[i] > 0) {
                System.out.println(denominations[i] + ":" + payment[i]);
            }
        }

        input.close();
    }

}
