package com.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ifl_6 {

    public static boolean[] visited;
    public static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        List<List<Node>> field = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            field.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;  // 초기화를 무한대로 설정
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            field.get(a).add(new Node(b, c));
        }

        dijkstra(1, field);  // 1번 정점에서 시작

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(i + ":" + "impossible");
            } else {
                System.out.println(i + ":" + distance[i]);
            }
        }
    }

    private static void dijkstra(int st, List<List<Node>> field) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(st, 0));
        distance[st] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentNode = node.ed;

            // 이미 방문한 노드는 건너뛰기
            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Node nd : field.get(currentNode)) {
                int nextNode = nd.ed;
                int nextVal = nd.val;

                if (distance[currentNode] + nextVal < distance[nextNode]) {  // 최소값으로 갱신
                    distance[nextNode] = distance[currentNode] + nextVal;
                    pq.add(new Node(nextNode, distance[nextNode]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int ed;
        int val;

        public Node(int ed, int val) {
            this.ed = ed;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
