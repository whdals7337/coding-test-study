package realization;

import java.util.ArrayList;
import java.util.Scanner;

class Position2 {
    private int x;
    private int y;

    public Position2(int x, int y) {
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

class Combination {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Position2>> result;

    public  Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position2>>();

    }

    public ArrayList<ArrayList<Position2>> getResult() {
        return result;
    }

    public void combination(ArrayList<Position2> arr, int depth, int index, int target){
        if(depth == r) {
            ArrayList<Position2> temp = new ArrayList<>();
            for(int i = 0; i < now.length; i++){
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if(target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

// 삼성전자 SW 역량테스트 - 치킨 배달 문제
public class RealizationTest11{

    public static int n, m;
    public static int[][] map = new int[50][50];
    public static ArrayList<Position2> chickens = new ArrayList<>();
    public static ArrayList<Position2> houses = new ArrayList<>();

    // 각 집에서 가장 가까운 치킨 집까지의 거리의 총합 메서드
    public static int getSum(ArrayList<Position2> candidates){
        int sum = 0;
        for(int i = 0; i < houses.size(); i++){
            int hx = houses.get(i).getX();
            int hy = houses.get(i).getY();

            int temp = (int)1e9;
            for(int j = 0; j < candidates.size(); j++){
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp,(Math.abs(hx - cx) + Math.abs(hy - cy)));
            }
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) houses.add(new Position2(i, j));
                else if(map[i][j] == 2) chickens.add(new Position2(i, j));
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        Combination comb = new Combination(chickens.size(), m);
        comb.combination(chickens, 0, 0, 0);
        ArrayList<ArrayList<Position2>> chickenList = comb.getResult();

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }
}