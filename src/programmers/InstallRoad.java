package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Road {
    int x;
    int y;
    int cost;
    int dir;

    public Road(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}

// 프로그래머스 경주로 건설 문제
class InstallRoad {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        map = board;
        bfs(new Road(0, 0, 0, -1));
        return answer;
    }

    void bfs(Road road){
        Queue<Road> queue = new LinkedList<>();
        queue.add(road);
        map[road.x][road.y] = 1; // 출발지점 벽으로 처리

        while (!queue.isEmpty()) {
            Road now = queue.poll();

            if(now.x == map.length - 1 && now.y == map[map.length - 1].length - 1) {
                answer = Math.min(answer, now.cost);
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                // 범위 밖인 경우
                if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[map.length - 1].length) continue;

                // 벽인 경우
                if (map[nextX][nextY] == 1) continue;

                // 다음 지점 비용
                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == i) {
                    nextCost += 100;
                }else {
                    nextCost += 600;
                }

                // 첫 방문 또는 이전 방문보다 비용이 적거나 같은 경우
                if(map[nextX][nextY] == 0 || map[nextX][nextY] >= nextCost) {
                    map[nextX][nextY] = nextCost;
                    queue.add(new Road(nextX, nextY, nextCost, i));
                }
            }
        }
    }
}