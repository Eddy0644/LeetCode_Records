class Solution3 {
    public static int countOperations(int num1, int num2) {
        int count = 0;
        for (; num1 != 0 && num2 != 0; count++) {
            if (num1 >= num2) num1 -= num2;
            else num2 -= num1;
        }
        return count;
    }
}
public class countOperations {
    public static void main(String[] args) {
        System.out.println(Solution3.countOperations(5,4));
        System.out.println(Solution3.countOperations(2,3));
        System.out.println("Run successful.");
    }
}
