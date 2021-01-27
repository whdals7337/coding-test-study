package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 고층 건물 문제 - 1027번
public class Skyscraper {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n+1];
        int[] counts = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // i 지점을 0,0 으로 생각하고 다른 건물과 기울기를 통해서 계산
        for(int i = 1; i <= n; i++) {
            // 최초 기울기 초기화
            double e = -9999999999d;

            // 왼쪽에서 오른쪽 건물을 볼때 이전 최대 기울기보다 기울기가 크면 해당 건물이 보인다는 의미
            // 왼쪽에서 오른쪽 건물이 보인다는 의미는 오른쪽 건물에서 왼쪽 건물이 보인다는 의미
            for(int j = i+1; j <= n; j++) {
                // 두 건물의 기울기
                double d = (double) (buildings[j] - buildings[i]) / (j - i);
                if(d > e) {
                    // 왼쪽에서 오른쪽을 볼때와 오른쪽에서 왼쪽을 볼때 둘다 +1
                    counts[i]++;
                    counts[j]++;

                    // 최대 기울기 갱신
                    e = d;
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result = Math.max(result, counts[i]);
        }
        System.out.println(result);
    }
}