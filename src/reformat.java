class Solution {
    public static String reformat(String s) {
        StringBuilder ans = new StringBuilder(s);
        int length = s.length();
        boolean lastType = getType(1, ans);
        for (int i = 1; i < length; ) {
            //no first elem
            if (lastType != getType(i, ans)) {
            } else {
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

    public static boolean getType(char ch) {
        // Letter 0, int 1
        if (ch >= 'a' && ch <= 'z') return false;
//        else if (ch >= '0' && ch <= '9') return true;
        return true;
    }

    public static boolean getType(int index, StringBuilder s) {
        return getType(s.charAt(index));
    }
}

public class reformat {
    public static void main(String[] args) {
        System.out.println(Solution.reformat("covid2019"));
        System.out.println(Solution.reformat("ab123"));
        System.out.print("Run successful.");
    }
}
