package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 합이 0인 네정수 문제 - 7453번
public class Sum04Value {

    static int N;
    static long[][] lists;
    static long[] AB, CD;
    static long count = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        lists= new long[4][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 4; j++) {
                lists[j][i] = Long.parseLong(st.nextToken());
            }
        }

        // A와 B , C와 D를 합치는 모든 경우의 수를 AB, CD배열에 각각 담음
        int sumIndex = 0;
        AB = new long[N * N];
        CD = new long[N * N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                AB[sumIndex] = lists[0][i] + lists[1][j];
                CD[sumIndex] = lists[2][i] + lists[3][j];
                sumIndex++;
            }
        }
        // 배열 정렬
        Arrays.sort(AB);
        Arrays.sort(CD);

        // 투포인터
        int leftIdx = 0; // AB의 포인터
        int rightIdx = N * N -1; // CD의 포인터
        while (leftIdx < N * N && rightIdx >= 0) {
            long leftValue = AB[leftIdx];
            long rightValue = CD[rightIdx];

            // 두 값이 0이되는 경우
            if(leftValue + rightValue == 0){
                // 0이 될때의 왼쪽 값과 같은 인자의 갯수
                long leftCount = 0;
                while(leftIdx < AB.length && AB[leftIdx] == leftValue) {
                    leftIdx++;
                    leftCount++;
                }

                // 0이 될때의 오른쪽 값과 같은 인자의 갯수
                long rightCount = 0;
                while(rightIdx >= 0 && CD[rightIdx] == rightValue) {
                    rightIdx--;
                    rightCount++;
                }

                // 왼쪽 인자 갯수와 오른쪽 인자 갯수의 조합의 갯수이므로 곱
                count += leftCount * rightCount;
            }

            // 두개의 합이 0보다 크면 오른쪽 인덱스를 -1
            if(leftValue + rightValue > 0) {
                rightIdx--;
            }

            // 두개의 합이 0보다 작으면 왼쪽 인덱스를 +1
            if(leftValue + rightValue < 0) {
                leftIdx++;
            }
        }
        System.out.println(count);
    }
}