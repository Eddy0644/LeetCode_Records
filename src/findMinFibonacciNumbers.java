import java.util.ArrayList;

class Solution9 {
    public static int findMinFibonacciNumbers(int k) {
        // rewritten with arraylist, got better records
        // first get nearest fibonacci number
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        int lastVal = 2, lastIndex = 1;
        while (k >= lastVal) {
            // At here to addElement to avoid lastVal > k
            fibonacci.add(lastVal);
            lastVal = fibonacci.get(lastIndex) + fibonacci.get(lastIndex - 1);
            lastIndex++;
        }
        int nowIndex = lastIndex - 1, nowVal, count = 0;
        while (k > 0) {
            if (nowIndex < 0) return -1;
            nowVal = fibonacci.get(nowIndex);
            if (k >= nowVal) {
                k -= nowVal;
                count++;
            } else {
                nowIndex--;
            }
        }
        if (k == 0) return count;
        else return -1;
    }
}

public class findMinFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(Solution9.findMinFibonacciNumbers(5));
        System.out.println(Solution9.findMinFibonacciNumbers(19));
        System.out.print("Run successful.");
    }
}
