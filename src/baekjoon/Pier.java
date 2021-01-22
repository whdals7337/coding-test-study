package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class BridgePostion implements Comparable<BridgePostion> {
    private int y;
    private int x1;
    private int x2;

    public BridgePostion(int y, int x1, int x2) {
        this.y = y;
        this.x1 = x1;
        this.x2 = x2;
    }

    public int getY(){
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    @Override
    public int compareTo(BridgePostion o) {
        return Integer.compare(o.y, this.y);
    }
}

//교각 놓기 문제 1276번
public class Pier {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<BridgePostion> bridges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            bridges.add(new BridgePostion(y, x1, x2));
        }
        Collections.sort(bridges);

        int result = 0;
        for(int i = 0; i < n; i++) {
            int ty = bridges.get(i).getY();
            int tx1 = bridges.get(i).getX1();
            int tx2 = bridges.get(i).getX2();

            for(int a = i+1; a <= n; a++) {
                if(a == n) {
                    result += ty;
                    break;
                }
                int dy = bridges.get(a).getY();
                int dx1 = bridges.get(a).getX1();
                int dx2 = bridges.get(a).getX2();

                if(tx1 >= dx1 && tx1 < dx2) {
                    result += ty - dy;
                    break;
                }
            }

            for(int a = i+1; a <= n; a++) {
                if(a == n) {
                    result += ty;
                    break;
                }
                int dy = bridges.get(a).getY();
                int dx1 = bridges.get(a).getX1();
                int dx2 = bridges.get(a).getX2();

                if(tx2 > dx1 && tx2 <= dx2) {
                    result += ty - dy;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}