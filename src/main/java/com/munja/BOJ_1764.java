package com.munja;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Set<String> li = new HashSet<>();

        for (int i = 0; i < n; i++) {
            li.add(sc.nextLine());
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            if (li.contains(s)) {
                answer.add(s);
            }
        }

        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
