import java.util.Vector;

class Solution {
    public static int findMinFibonacciNumbers(int k) {
        // first get nearest fibon number
//        int[] fibon=new int[];
        Vector<Integer> fibonacci = new Vector<>();
        fibonacci.addElement(1);
        int lastVal = 2, lastIndex = 1;
        while (k > lastVal) {
            // At here to addElement to avoid lastVal > k
            fibonacci.addElement(lastVal);
            lastVal = fibonacci.elementAt(lastIndex) + fibonacci.elementAt(lastIndex - 1);
            lastIndex++;
        }
        int nowIndex = lastIndex, nowVal, count = 0;
        while (k > 0) {
            if (nowIndex < 0) return -1;
            nowVal = fibonacci.elementAt(nowIndex);
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
        System.out.println(Solution.findMinFibonacciNumbers(19));
        System.out.println("Run successful.");
    }
}
