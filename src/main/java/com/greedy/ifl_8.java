package com.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ifl_8 {

    public static class Node implements Comparable<Node> {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static List<List<Node>> field;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        field = new ArrayList<>();
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            field.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            field.get(a).add(new Node(b, c));
            field.get(b).add(new Node(a, c));
        }

        int answer = prim(1);

        System.out.println(answer);
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int totalCost = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.dest]) continue;

            visited[current.dest] = true;
            totalCost += current.cost;

            for (Node neighbor : field.get(current.dest)) {
                if (!visited[neighbor.dest]) {
                    pq.offer(new Node(neighbor.dest, neighbor.cost));
                }
            }
        }

        return totalCost;
    }
}
