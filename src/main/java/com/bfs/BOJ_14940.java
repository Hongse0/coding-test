package com.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14940 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] visited;
    public static int[][] field;
    public static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = 0;
        int y = 0;

        visited = new boolean[n][m];
        field = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = sc.nextInt();
                if(field[i][j] == 2){
                    x = i;
                    y = j;
                }
                if(field[i][j] == 0){
                    answer[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        bfs(x,y);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    System.out.println(-1 + " ");
                }else{
                    System.out.print(answer[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        answer[x][y] = 0;
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] arr = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if(nx >= 0 && nx <field.length && ny >= 0 && ny <field[0].length && field[nx][ny] != 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    answer[nx][ny] = answer[arr[0]][arr[1]] + 1;
                }
            }
        }

    }
}
