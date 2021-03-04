package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합 문제 - 11723번
public class BitmaskUnion {

    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        int s = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            int x = 0;
            switch (type) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    s = s | ( 1 << (x-1));
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    s = s & ~(1 << (x-1));
                    break;

                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if((s & (1 << (x-1))) != 0){
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;

                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    s = s ^ (1 << (x-1));
                    break;
                case "all":
                    s = (1 << 20) - 1;
                    break;
                case "empty":
                    s &= 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}