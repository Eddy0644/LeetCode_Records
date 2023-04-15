class Solution6 {
    public static int waysToChange0(int n) {
        int[] coin = new int[]{25, 10, 5, 1}, optimised = new int[4], now;
        int sum = n;
        for (int i = 0; i < 4; i++) {
            while (sum >= coin[i]) {
                optimised[i]++;
                sum -= coin[i];
            }
        }
        now = optimised.clone();
        for (int ca = 0; ca < now[0]; ca++) {
            for (int cb = 0; cb < now[1]; cb++) {

            }
        }
        return 0;
    }

    public static int waysToChange1(int n) {
        int a = 0, b = 0, c = 0, d = 0, sum = n, count = 0;
        while (sum >= 25) {
            a++;
            sum -= 25;
        }
        while (sum >= 10) {
            b++;
            sum -= 10;
        }
        while (sum >= 5) {
            c++;
            sum -= 5;
        }
        while (sum >= 1) {
            d++;
            sum -= 1;
        }
        System.out.printf("n=%d --> %d,%d,%d,%d\n", n, a, b, c, d);
        return 0;
    }

    public static int waysToChange(int n) {
        //Guided by 'math' solution
        int sum = 0;
        for (int i = 0; i * 25 <= n; i++) {
            int rest = n - i * 25, a0 = rest / 10, b0 = rest % 10 / 5;
            sum = (sum + ((a0 + 1) * (a0 + b0 + 1)) % 1000000007) % 1000000007;
        }
        return sum;
    }
}

public class waysToChange {
    public static void main(String[] args) {
        System.out.println(Solution6.waysToChange(53));
        System.out.println(Solution6.waysToChange(900750));
        System.out.println("Run successful.");
    }
}
