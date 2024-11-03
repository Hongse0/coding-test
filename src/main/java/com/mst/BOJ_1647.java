package com.mst;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1647 {

    public static List<List<Node>> field;
    public static boolean[] visited;

    public static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        field = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            field.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            field.get(a).add(new Node(b, c));
            field.get(b).add(new Node(a, c));
        }

        int answer = prim(1);

        System.out.println(answer);


    }


    public static int prim(int n) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(n, 0));

        int totalCost = 0;
        int maxEdgeCost = 0;

        while(!pq.isEmpty()) {
            Node nd = pq.poll();

            if(visited[nd.dest]){
                continue;
            }

            visited[nd.dest] = true;
            totalCost += nd.cost;
            maxEdgeCost = Math.max(maxEdgeCost, nd.cost);

            for(Node ne : field.get(nd.dest)) {
                if(!visited[ne.dest]){
                    pq.offer(ne);
                }
            }


        }

        return totalCost - maxEdgeCost;


    }

}
