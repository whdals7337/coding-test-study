package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 램프 문제 - 1034번
public class Lamp {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 완전히 동일한 패턴 행일 경우만 동시에 행이 켜질수 있음
        String[] rowStrings = new String[N];
        int[] zeroCntList = new int[N];

        for(int i= 0; i < N; i++) {
            rowStrings[i] = br.readLine();
            for(int j = 0; j < M; j++) {
                if(rowStrings[i].charAt(j) == '0') {
                    zeroCntList[i] += 1;
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        int maxCount = 0;
        for(int i = 0; i < N; i++) {
            int zeroCnt = zeroCntList[i];

            // K번 눌렀을때 전부 켜지는 행인 경우
            if((K%2 == zeroCnt%2) && zeroCnt <= K) {
                String targetStr = rowStrings[i];

                // 해당 행과 동일한 램프 구성을 가지는 경우를 count
                int count = 0;
                for(String rowStr : rowStrings) {
                    if (targetStr.equals(rowStr)) {
                        count += 1;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(maxCount);
    }
}