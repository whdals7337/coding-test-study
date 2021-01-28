package baekjoon;

import java.util.Scanner;

// 터렛 문제 - 1002번
public class Turret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){

            int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();

            // 두점 사이 거리
            double  d = Math.pow((x2-x1),2) + Math.pow((y2-y1),2);

            // 원의 중심이 같은 경우
            if(x1 == x2 && y1 == y2){
                // 원의 반지름이 같은 경우
                if(r1 == r2) System.out.println(-1);
                // 원의 반지름이 다른 경우
                if(r1 != r2) System.out.println(0);
            }
            // 원의 중심이 다른 경우
            else {
                //  반지름의 합이 두점 사이 거리보다 짧거나 (멀리 떨어진 상태)
                //  큰 반지름에서 작은 반지름을 뺀 거리가 두점 사이보다 긴 경우 (큰원안에 원이 들어와 있는 상태)
                if(Math.pow((r1+r2),2) < d || Math.pow((r1-r2),2) > d){
                    System.out.println(0);
                }
                else {
                    // 두점 사이의 거리가 반지름의 합과 같은경우 (두 원이 떨어진 상태로 만다는 경우)
                    // 두점 사이의 거리가 큰반지름에서 작은 반지름을 뺀 거리와 같은 경우 (큰원안에 다른 원이 들어와서 점으로 만나는 상태)
                    if (Math.pow((r1+r2),2) == d || Math.pow((r1-r2),2) == d) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(2);
                    }
                }
            }
        }
    }
}
