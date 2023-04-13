class Solution {
    public static int sumSubarrayMins(int[] arr) {
        int M = 1000000007;
        if (arr.length == 1) return arr[0];
        int min_sum = 0;
        for (int i = 0, j = 0; i < arr.length; ) {
            int temp_min = arr[i];
            for (int k = i; k <= j; k++) temp_min = Math.min(arr[k], temp_min);
            if (min_sum + temp_min > M) min_sum -= M;
            min_sum += temp_min;
            if (j == arr.length - 1) {
                i++;
                j = i;
            } else j++;
        }
        return min_sum % (1000000007);
    }
}

public class sumSubarrayMins {
    public static void main(String[] args) {
//        System.out.println(Solution.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(Solution.sumSubarrayMins(new int[]{11,81,94,43,3}));
        System.out.println("Run successful.");
    }
}
