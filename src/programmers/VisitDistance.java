package programmers;

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isRanged() {
        return this.x >= 0 && this.x < 11 && this.y >= 0 && this.y < 11;
    }

    public Position getNextPosition(char c) {
        // 상하좌우 U, D, L, R
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int temp = -1;
        switch (c) {
            case 'U':
                temp = 0;
                break;
            case 'D':
                temp = 1;
                break;
            case 'R':
                temp = 2;
                break;
            default:
                temp = 3;
                break;
        }
        return new Position(this.x + dx[temp], this.y + dy[temp]);
    }
}

// 프로그래머스 방문 거리 문제
class VisitDistance {
    static boolean[][][][] visited;
    static int answer = 0;
    public int solution(String dirs) {
        visited = new boolean[11][11][11][11];
        Position start = new Position(5, 5);
        for (int i = 0; i < dirs.length(); i++) {
            start = move(start, dirs.charAt(i));
        }
        return answer;
    }

    static Position move(Position start, char dir) {
        Position next = start.getNextPosition(dir);

        // 범위를 벗어나는 경우 이동 x
        if (!next.isRanged()) return start;

        // 방문 처리
        doVisit(start, next);

        return next;
    }

    static void doVisit(Position start, Position next) {
        // 방문하지 않은 경우 방문 처리
        if(!visited[start.getX()][start.getY()][next.getX()][next.getY()]) {
            visited[start.getX()][start.getY()][next.getX()][next.getY()] = true;
            visited[next.getX()][next.getY()][start.getX()][start.getY()] = true;
            answer++;
        }
    }
}