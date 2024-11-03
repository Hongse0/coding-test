package com.mst;


import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_16398 {

    public static class Node implements Comparable<Node>{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] field = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 1; i < n; i++){
            pq.offer(new Node(i, field[0][i]));
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        long answer = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.dest]){
                continue;
            }

            visited[node.dest] = true;
            answer += node.cost;

            for(int i = 0; i < n; i++){

                if(!visited[i]){
                    pq.offer(new Node(i, field[i][node.dest]));
                }
            }
        }

        System.out.println(answer);


    }
}
