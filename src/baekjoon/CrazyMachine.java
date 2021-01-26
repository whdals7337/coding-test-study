package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미친 로봇 문제 - 1405번
public class CrazyMachine {
    static int N;
    static double result;
    // 방문여부용 graph
    static boolean[][] map = new boolean[30][30];
    // 동서남북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 동서남북 방향 별 확률
    static Double[] direction = new Double[4];

    static void dfs(int x, int y, double percent) {
        if(N == 0) {
            result += percent;
            return;
        }
        map[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(!map[tx][ty] && direction[i] > 0) {
                N-=1;
                dfs(tx, ty, percent * direction[i]);
                N+=1;
                map[tx][ty] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 4; i++) {
            direction[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        dfs(15, 15, 1.0);
        System.out.println(result);
    }
}