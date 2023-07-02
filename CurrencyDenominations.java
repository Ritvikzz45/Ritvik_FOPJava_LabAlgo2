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
        
        Map<Integer, Integer> payment = new TreeMap<>(Collections.reverseOrder());
        // use a tree map to store the payment approach in descending order of denomination
        
        for (int i = n-1; i >= 0; i--) {
            int count = amount / denominations[i];
            
            if (count > 0) {
                payment.put(denominations[i], count);
                amount -= count * denominations[i];
            }
        }
        
        System.out.println("Your payment approach in order to give min no of notes will be:");
        for (Map.Entry<Integer, Integer> entry : payment.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        
        input.close();
    }
}