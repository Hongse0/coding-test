package com.nocategory;

import java.io.*;
import java.util.*;

public class BOJ_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
            Map<Integer, Integer> countMap = new HashMap<>(); // 동기화 및 삭제 관리

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    minHeap.add(n);
                    maxHeap.add(n);
                    countMap.put(n, countMap.getOrDefault(n, 0) + 1); // 삽입 시 count 증가
                } else if (command.equals("D")) {
                    if (n == 1) {
                        // 최대값 삭제
                        removeTop(maxHeap, countMap);
                    } else if (n == -1) {
                        // 최솟값 삭제
                        removeTop(minHeap, countMap);
                    }
                }
            }

            // 최종적으로 동기화된 최대값과 최솟값을 출력
            int max = getValidTop(maxHeap, countMap);
            int min = getValidTop(minHeap, countMap);

            if (min == Integer.MIN_VALUE && max == Integer.MIN_VALUE) {
                System.out.println("EMPTY");
            } else {
                System.out.println(max + " " + min);
            }
        }
    }

    // 힙에서 최상단 값을 제거하며 동기화하는 함수
    private static void removeTop(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {
        while (!heap.isEmpty()) {
            int value = heap.poll();
            if (countMap.getOrDefault(value, 0) > 0) {
                countMap.put(value, countMap.get(value) - 1);
                if (countMap.get(value) == 0) {
                    countMap.remove(value);
                }
                break;
            }
        }
    }

    // 힙에서 유효한 최상단 값을 가져오는 함수
    private static int getValidTop(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {
        while (!heap.isEmpty()) {
            int value = heap.peek();
            if (countMap.getOrDefault(value, 0) > 0) {
                return value;
            } else {
                heap.poll();
            }
        }
        return Integer.MIN_VALUE;
    }
}
