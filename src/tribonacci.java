class Solution13 {
    public static int tribonacci(int n) {
        int[] a=new int[38];
        a[0]=0;a[1]=1;a[2]=1;
        for (int i = 3; i <= n; i++) {
            a[i]=a[i-1]+a[i-2]+a[i-3];
        }
        return a[n];
    }
}
public class tribonacci {
    public static void main(String[] args) {
        System.out.println(Solution13.tribonacci(25));
        System.out.print("Run successful.");
    }
}
