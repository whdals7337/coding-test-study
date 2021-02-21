package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경사로 문제 - 14890번
class SlopeWay {
    static int n;
    static int L;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            // 행
            if (isRoute(i, 0, 0))
                count++;

            // 열
            if (isRoute(0, i, 1))
                count++;
        }

        System.out.println(count);
    }

    //  type = 0 이면 행, type = 1 이면 열
    static boolean isRoute(int x, int y, int type) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];     // 경사로가 이미 놓여있는지 확인

        // 검사할 영역의 높이
        for (int i=0; i<n; i++) {
            height[i] = (type == 0) ? map[x][y+i] : map[x+i][y];
        }

        for (int i=0; i<n-1; i++) {
            // 높이가 같은 경우
            if (height[i] == height[i+1]) {
                continue;
            }

            // 높이가 1보다 큰 경우
            if (Math.abs(height[i] - height[i+1]) > 1) {
                return false;
            }

            // 내려가야되는 경우
            if (height[i] - 1 == height[i+1]) {
                // 경사로 길이의 범위가 유효 하게 설치 가능한지 여부 체크
                for (int j=i+1; j<=i+L; j++) {
                    // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
                    if (j >= n || height[i+1] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 올라가야되는 경우
            else if (height[i] + 1 == height[i+1]) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}