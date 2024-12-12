package com.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ifl_2 {

    public static List<Integer> list; // 입력 리스트
    public static int answer = 0;    // 최대 합 저장 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 제한 값
        int N = sc.nextInt(); // 리스트 길이

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        // 내림차순 정렬로 큰 숫자부터 탐색 -> 가지치기 효율 향상
        Collections.sort(list, Collections.reverseOrder());

        dfs(C, 0, 0); // DFS 시작 (현재 합계: 0, 현재 인덱스: 0)

        System.out.println(answer);
    }

    public static void dfs(int c, int sum, int index) {
        // 가지치기: 현재 합이 제한을 넘으면 탐색 종료
        if (sum > c) return;

        // 최대값 갱신
        answer = Math.max(answer, sum);

        // 현재 인덱스부터 리스트를 탐색
        for (int i = index; i < list.size(); i++) {
            // 가지치기: 현재 합 + 다음 숫자가 c보다 큰 경우 스킵
            if (sum + list.get(i) > c) continue;

            // 재귀 호출: 다음 숫자 선택
            dfs(c, sum + list.get(i), i + 1);
        }
    }
}
