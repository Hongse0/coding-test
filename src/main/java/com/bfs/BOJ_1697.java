package com.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {


    public static class Node{
        int loca;
        int time;

        public Node(int loca, int time){
            this.loca = loca;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = bfs(n,k);

        System.out.println(answer);
    }

    private static int bfs(int n, int k) {
        if (n == k) return 0;
        boolean[] visited = new boolean[100001];


        Queue<Node> q= new LinkedList<>();
        visited[n] = true;
        q.offer(new Node(n,0));

        while (!q.isEmpty()) {
            Node nd = q.poll();

            // 세 가지 경우에 대해 탐색
            int[] nextLocs = {nd.loca - 1, nd.loca + 1, nd.loca * 2};

            for (int nextLoc : nextLocs) {
                if (nextLoc == k) { // 동생의 위치에 도달하면 즉시 시간 반환
                    return nd.time + 1;
                }

                if (nextLoc >= 0 && nextLoc <= 100000 && !visited[nextLoc]) {
                    visited[nextLoc] = true;
                    q.offer(new Node(nextLoc, nd.time + 1));
                }
            }
        }

        return -1;

    }
}
