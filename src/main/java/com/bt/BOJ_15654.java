package com.bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_15654 {

    public static List<Integer> list;
    public static boolean[] visited;
    public static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList<>();
        visited = new boolean[n];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        backTrack(0,m);
    }

    public static void backTrack(int depth, int m) {
        if (answer.size() == m) {
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(list.get(i));

                backTrack(depth + 1, m);

                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }




}
