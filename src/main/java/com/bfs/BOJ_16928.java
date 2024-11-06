package com.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16928 {

    public static boolean[] visited;
    public static int[] board;
    public static int[] moves;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        board = new int[101];
        moves = new int[101];
        visited = new boolean[101];

        for(int i = 1; i<board.length; i++){
            moves[i] = -1;
            board[i] = i;
        }

        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            board[x] = y;
        }

        for(int i = 0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            board[x] = y;
        }


        bfs(1,board,moves);

        System.out.println(moves[100]);


    }

    public static void bfs(int n, int[] board, int[] moves){

        visited[n] = true;
        moves[n] = 0;

        Queue<Integer> q = new LinkedList<>();

        q.offer(n);

        while(!q.isEmpty()){

            int k = q.poll();

            for(int i = 1; i<7; i++){
                int nk = k + i;

                if(nk > 100){
                    continue;
                }

                nk = board[nk];

                if(!visited[nk]){
                    visited[nk] = true;
                    moves[nk] = moves[k] +1;
                    q.add(nk);
                }
            }
        }


    }
}
