package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 수열 - 11054번
public class LongestBytonic {

    static int N;
    static int[] seq;
    static int[] rdp;
    static int[] ldp;

    static void LIS() {
        for(int i = 0; i < N; i++) {
            rdp[i] = 1;

            // 0 ~ i 이전 원소들 탐색
            for(int j = 0; j < i; j++) {
                if(seq[j] < seq[i] && rdp[i] < rdp[j] + 1) {
                    rdp[i] = rdp[j] + 1;
                }
            }
        }
    }

    static void LDS() {
        // 뒤에서부터 시작
        for (int i = N - 1; i >= 0; i--) {
            ldp[i] = 1;

            // 맨 뒤에서 i 이전 원소들을 탐색
            for (int j = N - 1; j > i; j--) {
                if (seq[j] < seq[i] && ldp[i] < ldp[j] + 1) {
                    ldp[i] = ldp[j] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rdp = new int[N];	// LIS
        ldp = new int[N];	// LDS
        seq = new int[N];   // 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int result = 0;
        for(int i = 0; i < N; i++) {
            result = Math.max(result, rdp[i] + ldp[i]);
        }

        // LIS 와 LDS 겹치는 부분 뺌
        System.out.println(result - 1);
    }
}