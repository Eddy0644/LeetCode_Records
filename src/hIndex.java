class Solution {
    public static int hIndex(int[] citations) {
        int[] ac = new int[1000];
        int maxQuote = 0;
        for (int i : citations) {
            ac[i]++;
            maxQuote = Math.max(maxQuote, i);
        }
        int sumLeft = 0;
        for (int i = maxQuote; i > 0; i--) {
            if (i >= sumLeft && i <= sumLeft+ac[i]) {
                return i;
            }
            sumLeft += ac[i];
        }
        return 0;
    }
}

public class hIndex {
    public static void main(String[] args) {
        System.out.println(Solution.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(Solution.hIndex(new int[]{1, 3, 1}));
        System.out.println("Run successful.");
    }
}
