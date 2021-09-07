package programmers;

import java.util.*;

// 프로그래머스 - 거리두기 확인하기 문제
class Site {
    private final int x;
    private final int y;
    private final int distance;

    Site(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}

public class Distancing {
    // 상하좌우
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    // 대기실 크기
    private static final int ROW = 5;
    private static final int COLUMN = 5;
    // 대기실 내부 유형(사람, 빈 테이블)
    private static final char PERSON = 'P';
    private static final char EMPTY = 'O';

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        // 대기실 순회
        for (int x = 0; x < places.length; x++) {
            List<Site> people = new ArrayList<>();
            char[][] map = settingMapAndPeople(places[x], people);

            for (Site person : people) {
                if(!isBreakRule(person, map)) {
                    answer[x] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    private char[][] settingMapAndPeople(String[] places, List<Site> people) {
        char[][] temp = new char[ROW][COLUMN];
        for (int i = 0; i < ROW; i++) {
            for(int j = 0 ; j < COLUMN; j++) {
                temp[i][j] = places[i].charAt(j);
                if (temp[i][j] == PERSON) {
                    people.add(new Site(i, j,0));
                }
            }
        }
        return temp;
    }

    private boolean isBreakRule(Site site, char[][] map) {
        Queue<Site> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROW][COLUMN];
        q.offer(site);

        while (!q.isEmpty()) {
            Site now = q.poll();

            // 현재 맨해튼 거리가 2 이상인 경우
            if (now.getDistance() >= 2) continue;

            visited[now.getX()][now.getY()] = true;

            for(int i = 0; i < 4; i++) {
                int tx = now.getX() + dx[i];
                int ty = now.getY() + dy[i];
                int tDistance =  now.getDistance() + 1;

                // 범위 밖 또는 이미 방문
                if (isOutRanged(tx, ty) || visited[tx][ty]) continue;

                // 사람인 경우
                if(map[tx][ty] == PERSON) {
                    return false;
                }

                // 빈 테이블
                if(map[tx][ty] == EMPTY) {
                    q.offer(new Site(tx, ty, tDistance));
                }
            }
        }

        return true;
    }

    private boolean isOutRanged(int x, int y) {
        return x < 0 || x >= ROW || y < 0 || y >= COLUMN;
    }
}
