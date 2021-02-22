package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄 세우기 문제 - 2252번
public class LiningStudent {

    static int N, M;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        // 학생 수
        N = Integer.parseInt(st.nextToken());

        // 진입 차수 배열 초기화
        inDegree = new int[N+1];

        // graph 초기화
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 키를 비교한 횟수
        M = Integer.parseInt(st.nextToken());

        // 비교 내용을 통해서 graph, 진입차수 셋팅
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b] += 1;
        }

        // 진입차수가 0 인 경우를 큐에 추가
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐 순회
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.poll();

            // 현재 학생을 결과 값에 추가
            sb.append(now).append(" ");

            // 현재 학생보다 키큰 학생들을 진입차수 -1
            ArrayList<Integer> students = graph.get(now);
            for (Integer student : students) {
                inDegree[student] -= 1;

                // 진입 차수가 0이 된 학생을 큐에 추가
                if(inDegree[student] == 0) q.offer(student);
            }
        }
        System.out.println(sb);
    }
}