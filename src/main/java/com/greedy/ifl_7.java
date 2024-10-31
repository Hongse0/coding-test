package com.greedy;

import java.util.*;

public class ifl_7 {

    public static int[] field;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        field = new int[n+1];

        for (int i = 1; i <= n; i++) {
            field[i] = i;
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            Union(a,b);
        }

        int st = sc.nextInt();
        int ed = sc.nextInt();

        int fa = Find(st);
        int fb = Find(ed);

        if(fa== fb){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }

    private static void Union(int a, int b) {

        int fa = Find(a);
        int fb = Find(b);

        if(fa != fb){
            field[fa] = fb;
        }
    }

    private static int Find(int a) {
        if(field[a] == a){
            return a;
        }else{
            field[a] = Find(field[a]);
            return field[a];
        }


    }


}
