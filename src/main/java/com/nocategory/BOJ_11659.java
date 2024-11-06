package com.nocategory;

import java.util.Scanner;

public class BOJ_11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = dp[i-1] + arr[i];
        }

        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int answer = dp[b] - dp[a-1];
            System.out.println(answer);
        }


    }
}
