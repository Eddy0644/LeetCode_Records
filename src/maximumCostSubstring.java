class Solution8 {
    public static int maximumCostSubstring0(String s, String c, int[] v) {
        int length = s.length(), max = 0;
        boolean v_all_pos = true;
        for (int v1 : v) {
            if (v1 < 0) {
                v_all_pos = false;
                break;
            }
        }
        if (v_all_pos) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += getVal(s.charAt(i), c, v);
            }
            return sum;
        }
        for (int i = 0; i < length; i++) {
            if (getVal(s.charAt(i), c, v) < 0) continue;
            for (int j = i; j < length; j++) {
                int sumOfSub = 0;
                for (int k = i; k <= j; k++) {
                    sumOfSub += getVal(s.charAt(k), c, v);
                }
                if (sumOfSub < 0) {
                    i = j;
                    break;
                }
                max = Math.max(sumOfSub, max);
            }
        }
        return max;
    }

    public static int maximumCostSubstring(String s, String c, int[] v) {
        //Guided using simple dp
        //PS: do not use two-layer circulation
        int pre = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = getVal(s.charAt(i), c, v);
            if (pre + cur < 0) pre = 0;
            else pre += cur;
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int getVal(char a, String chars, int[] vals) {
        int pos = chars.indexOf(a);
        if (pos == -1) {
            return a - 'a' + 1;
        } else return vals[pos];
    }
}

public class maximumCostSubstring {
    public static void main(String[] args) {
        System.out.println(Solution8.maximumCostSubstring(
                "adaa", "d", new int[]{-1000}
        ));
        System.out.println(Solution8.maximumCostSubstring(
                "abc", "abc", new int[]{-1, -1, -1}
        ));
        System.out.println("Run successful.");
    }
}
