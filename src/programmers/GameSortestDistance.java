package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 게임 맵 최단거리 문제
class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int row = maps.length;
        int column = maps[0].length;
        visited = new boolean[row][column];
        dp = new int[row][column];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        bfs(0,0, maps);

        return dp[row - 1][column - 1];
    }

    static void bfs(int x, int y, int[][] maps) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(x, y));
        visited[x][y] = true;
        dp[x][y] = 1;

        while (!q.isEmpty()) {
            Dot now = q.poll();

            for (int i = 0 ; i < 4; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];

                // 범위를 벗어 나는 경우
                if(tx < 0 || tx >= maps.length || ty < 0 || ty >= maps[0].length) continue;

                // 벽인 경우
                if(maps[tx][ty] == 0) continue;

                // 미방문인 경우 방문 처리 및 dp 값 셋팅
                if(!visited[tx][ty]) {
                    visited[tx][ty] = true;
                    dp[tx][ty] = dp[now.x][now.y] + 1;
                    q.offer(new Dot(tx, ty));
                }
            }
        }
    }
}