package depth_first_search;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}


class Position{
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// 감시 피하기 문제
public class DepthFirstSearchTest5 {

    public static int n;
    public static char[][] map = new char[6][6];
    public static ArrayList<Position> spaces = new ArrayList<Position>();
    public static ArrayList<Position> teachers = new ArrayList<Position>();

    // 해당 방향에 학생을 감지하는지 확인
    public static boolean watch(int x, int y, int direction){
        // 왼쪽
        if(direction == 0){
            while(y >= 0){
                //학생일 경우
                if (map[x][y] == 'S') {
                    return true;
                }
                //벽일 경우
                else if(map[x][y] == 'O'){
                    return false;
                }
                y -= 1;
            }
        }
        // 위
        else if(direction == 1){
            while(x >= 0){
                //학생일 경우
                if (map[x][y] == 'S') {
                    return true;
                }
                //벽일 경우
                else if(map[x][y] == 'O'){
                    return false;
                }
                x -= 1;
            }
        }
        // 오른쪽
        else if(direction == 2){
            while(y < n){
                //학생일 경우
                if (map[x][y] == 'S') {
                    return true;
                }
                //벽일 경우
                else if(map[x][y] == 'O'){
                    return false;
                }
                y += 1;
            }
        }
        // 아래
        else if(direction == 3){
            while(x < n){
                //학생일 경우
                if (map[x][y] == 'S') {
                    return true;
                }
                //벽일 경우
                else if(map[x][y] == 'O'){
                    return false;
                }
                x += 1;
            }
        }
        return false;
    }

    // 장애물 설치후 감지 여부 확인
    public static boolean check(){
        // 모든 선생님의 상하좌우에 학생이 위치하고 있는지 확인
        for(int i = 0; i < teachers.size(); i++){
            int x = teachers.get(i).getX();
            int y = teachers.get(i).getY();

            for(int j = 0; j < 4; j++){
                if (watch(x, y, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.next().charAt(0);

                // 선생님 목록
                if(map[i][j] == 'T'){
                    teachers.add(new Position(i, j));
                }
                // 빈 공간 목록
                else if(map[i][j] == 'X'){
                    spaces.add(new Position(i, j));
                }
            }
        }

        // 빈공간에 3개의 벽을 설치하는 모든 경우의 수
        Combination comb = new Combination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> spaceList = comb.getResult();

        // 감시를 탈출할 경우를 찾았는지 여부
        boolean found = false;
        for(int i = 0; i < spaceList.size(); i++){
            for(int j = 0; j < spaceList.get(i).size(); j++){
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                map[x][y] = 'O';
            }

            // 감시 확인
            if(!check()){
                found = true;
                break;
            }

            // 이전 상태로 초기화
            for(int j = 0; j < spaceList.get(i).size(); j++){
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                map[x][y] = 'X';
            }
        }

        if(found){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
