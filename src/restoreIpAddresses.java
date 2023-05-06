import java.util.ArrayList;
import java.util.List;

class Solution12 {
    public static List<String> restoreIpAddresses(String s) {
        int head=0, len = s.length();
        List<String> ans = new ArrayList<>();
            for (int a = 0; a < 3; a++) {
                if (head + a == len) break;
                int Na = Integer.parseInt(s.substring(head, head + a + 1));
                if (Na > 255 || ("" + Na).length() != a + 1) continue;
                int Pa = head + a + 1;
                for (int b = 0; b < 3; b++) {
                    if (Pa + b == len) break;
                    int Nb = Integer.parseInt(s.substring(Pa, Pa + b + 1));
                    if (Nb > 255 || ("" + Nb).length() != b + 1) continue;
                    int Pb = Pa + b + 1;
                    for (int c = 0; c < 3; c++) {
                        if (Pb + c == len) break;
                        int Nc = Integer.parseInt(s.substring(Pb, Pb + c + 1));
                        if (Nc > 255 || ("" + Nc).length() != c + 1) continue;
                        int Pc = Pb + c + 1;
                        for (int d = 0; d < 3; d++) {
                            if (Pc + d == len) break;
                            int Nd = Integer.parseInt(s.substring(Pc, Pc + d + 1));
                            if (Nd > 255 || ("" + Nd).length() != d + 1) continue;
                            if (Pc + d + 1 == len) ans.add(Na + "." + Nb + "." + Nc + "." + Nd);
                        }
                        if(Nc==0)break;
                    }
                    if(Nb==0)break;
                }
                if(Na==0)break;
            }

        return ans;
    }
}

public class restoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(Solution12.restoreIpAddresses("25525511135"));
        System.out.println(Solution12.restoreIpAddresses("101023"));
        System.out.print("Run successful.");
    }
}
