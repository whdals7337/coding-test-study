package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳 문제 - 1987번
public class Alphabet {

    static int R, C;
    static int result = 0;
    static int[][] map;
    static boolean[] check = new boolean[28];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static void DFS(int x, int y, int count) {
        result = Math.max(result, count);

        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(tx < 0 || tx >= R || ty < 0 || ty >= C) continue;

            if(check[map[tx][ty]]) continue;
            else {
                check[map[tx][ty]] = true;
                DFS(tx, ty, count + 1);
                check[map[tx][ty]] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for(int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j) - 'A';
            }
        }

        check[map[0][0]] = true;
        DFS(0,0, 1);
        System.out.println(result);
    }
}