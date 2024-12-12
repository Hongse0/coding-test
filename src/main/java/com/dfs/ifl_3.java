package com.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ifl_3 {

    public static List<Node> field;
    public static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        field = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node node = new Node(a, b);
            field.add(node);
        }

        dfs(M, 0,0, 0);

        System.out.println(answer);


    }

    public static void dfs(int m, int tsum,int scsum, int idx) {

        if(tsum > m){
            return;
        }

        answer = Math.max(answer,scsum);

        for (int i = idx; i < field.size(); i++) {
            Node node = field.get(i);

            if(node.time + tsum > m){
                continue;
            }



            dfs(m, node.time + tsum, scsum+ node.score,i+1);
        }
    }

    public static class Node {
        int score;
        int time;

        public Node(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
