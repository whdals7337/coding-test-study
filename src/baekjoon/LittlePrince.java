package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Plant {
    int x;
    int y;
    int r;

    public Plant(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

// 어린 왕자 문제 - 1004번
public class LittlePrince {

    static int T;

    static boolean isContained(Plant plant, int x, int y) {
        double distance = Math.pow(plant.x - x, 2) + Math.pow(plant.y - y, 2);
        return distance < Math.pow(plant.r, 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 반복
        while (T --> 0){
            int count = 0; // 진입/이탈 횟수 초기화

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 출발점
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            // 도착점
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine()); // 행성계 개수
            ArrayList<Plant> circleArrayList = new ArrayList<>();

            // 행성계 목록
            for(int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                int r = Integer.parseInt(st2.nextToken());
                circleArrayList.add(new Plant(x,y,r));
            }

            // 행성계
            for (Plant plant : circleArrayList) {
                boolean startContain = isContained(plant, startX, startY); // 시작점 포함 여부
                boolean endContain = isContained(plant, endX, endY); // 도착점 포함 여부

                // 특정 행성계에 둘중 하나만 포함되었을 경우
                if((!startContain && endContain) || (startContain && !endContain)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}