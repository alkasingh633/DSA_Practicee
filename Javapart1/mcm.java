package Javapart1;

import java.util.Scanner;

public class mcm {

    static void matrixChainOrder(int[] p, int n) {

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {

                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum multiplication cost: " + m[1][n]);

        System.out.print("Optimal parenthesization: ");
        printOptimalParens(s, 1, n);

        System.out.println("\n\nCost Table:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i) {
                    System.out.print("-\t");
                } else {
                    System.out.print(m[i][j] + "\t");
                }
            }
            System.out.println();
        }

        System.out.println("\nSplit Table:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    System.out.print("-\t");
                } else {
                    System.out.print(s[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    static void printOptimalParens(int[][] s, int i, int j) {

        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        matrixChainOrder(p, n);

        sc.close();
    }
}
