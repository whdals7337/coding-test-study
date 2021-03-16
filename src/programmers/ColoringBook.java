package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 카카오프렌즈 컬러링북 문제
class ColoringBook {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                    numberOfArea += 1;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int bfs(int x, int y, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, picture[x][y]});
        visited[x][y] = true;
        int areaSize = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            int curColor = now[2];

            for(int i = 0; i < 4; i++) {
                int tx = cx + dx[i];
                int ty = cy + dy[i];

                // 사진 밖으로 나가는 경우
                if(tx < 0 || tx >= picture.length || ty < 0 || ty >= picture[tx].length) continue;

                // 같은 색상 && 미방문인 경우
                if(picture[tx][ty] == curColor && !visited[tx][ty]) {
                    // 방문 처리
                    visited[tx][ty] = true;
                    q.offer(new int[]{tx, ty, picture[tx][ty]});
                    areaSize += 1;
                }
            }
        }
        return areaSize;
    }
}