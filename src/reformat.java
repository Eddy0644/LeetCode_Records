import java.util.Vector;

class Solution {
    public static String reformat0(String s) {
        StringBuilder ans = new StringBuilder(s);
        int length = s.length();
        boolean lastType = getType(1, ans);
        for (int i = 1; i < length; ) {
            //no first elem
            if (lastType == getType(i, ans)) {
                //need to move elem
                boolean flag = true;
                if (i == length - 1) return "";
                for (int j = i + 1; j < length; j++) {
                    if (lastType != getType(j, ans)) {
                        // found neq elem, replace them
                        ans.replace(i, i, String.valueOf(ans.charAt(j)));
                        ans.deleteCharAt(j + 1);
                        flag = false;
                        break;
                    }
                }
                if (flag) return "";
            }
            lastType = !lastType;
            i++;
        }
        return ans.toString();
    }

    public static String reformat(String s) {
        //用数组能够更快地解决问题，因为在开头处不好把控
        Vector<Character> nums = new Vector<>(),
                alphas = new Vector<>(), a, b;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                alphas.addElement(s.charAt(i));
            } else nums.addElement(s.charAt(i));
        }
        if (Math.abs(nums.size() - alphas.size()) > 1) return "";

        if (nums.size() > alphas.size()) {
            a = nums;
            b = alphas;
        } else {
            a = alphas;
            b = nums;
        }
        int ai = 0, bi = 0;
        StringBuilder ans = new StringBuilder();
        while (ai < a.size() && bi < b.size()) {
            ans.append(a.elementAt(ai++));
            ans.append(b.elementAt(bi++));
        }
        if (ai < a.size()) ans.append(a.elementAt(ai));
        return ans.toString();
    }

    public static boolean getType(char ch) {
        // Letter 0, int 1
        return ch < 'a' || ch > 'z';
    }

    public static boolean getType(int index, StringBuilder s) {
        return getType(s.charAt(index));
    }
}

public class reformat {
    public static void main(String[] args) {
        System.out.println(Solution.reformat("covid2019"));
        System.out.println(Solution.reformat("a0b1c2"));
        System.out.print("Run successful.");
    }
}
