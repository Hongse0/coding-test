package com.dfs;

import java.util.Scanner;

public class ifl_1 {

    public static int[] list;
    public static int n;
    public static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            sum += list[i];
        }

        // 부분집합으로 나눌 수 없는 경우 체크
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int target = sum / 2;
        dfs(0, 0, target);

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(int idx, int subsetSum, int target) {
        if (found || subsetSum > target) return;  // 이미 답을 찾았거나 초과하면 종료
        if (subsetSum == target) {
            found = true; // 목표 합을 찾음
            return;
        }

        if (idx >= n) return; // 배열의 범위를 벗어나면 종료

        // 현재 원소를 선택하거나 선택하지 않음
        dfs(idx + 1, subsetSum + list[idx], target); // 현재 원소 포함
        dfs(idx + 1, subsetSum, target); // 현재 원소 미포함
    }
}
