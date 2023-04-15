import java.util.Deque;
import java.util.LinkedList;

class Solution4 {
    @SuppressWarnings("PointlessBooleanExpression")
    public static int sumSubarrayMins(int[] arr) {
        //Guided 2nd code - used mono stack
        int M = 1000000007;
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while ((stack.isEmpty() == false) && (arr[stack.peek()] > arr[i])) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i > -1; i--) {
            while ((stack.isEmpty() == false) && (arr[stack.peek()] >= arr[i])) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % M;
        }
        return (int)ans;
    }

    public static int sumSubarrayMins1(int[] arr) {
        //Self produced code - 1st
        int M = 1000000007;
        if (arr.length == 1) return arr[0];
        int min_sum = 0, temp_min = -1;
        for (int i = 0, j = 0; i < arr.length; ) {
            if (temp_min == -1) {
                temp_min = arr[i];
//                for (int k = i; k <= j; k++) temp_min = Math.min(arr[k], temp_min);
            } else {
                //only j changed since last iteration
                temp_min = Math.min(arr[j], temp_min);
            }
            if (min_sum + temp_min > M) min_sum -= M;
            min_sum += temp_min;
            if (j == arr.length - 1) {
                i++;
                j = i;
                temp_min = -1;
            } else j++;
        }
        return min_sum % (1000000007);
    }
}

public class sumSubarrayMins {
    public static void main(String[] args) {
        System.out.println(Solution4.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(Solution4.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println("Run successful.");
    }
}
