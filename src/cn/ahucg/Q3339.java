package cn.ahucg;

import java.util.Scanner;

public class Q3339 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), rowMax;
        int[][] arr = new int[n][n];
        int[] maxInRow = new int[n];
        for (int i = 0; i < n; i++) {
            rowMax = 0;
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] > rowMax) {
                    rowMax = arr[i][j];
                    maxInRow[i] = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int row = maxInRow[i], p, base = arr[i][row], flag = 1;
            for (int j = 0; j < n; j++) {
                p = arr[j][row];
                if (p < base && j != i) {
                    // this number is not ans
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                System.out.printf("%d %d", i, row);
                return;
            }
        }
        System.out.println("NONE");
    }
}
