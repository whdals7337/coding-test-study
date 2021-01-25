package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 리모콘 문제 - 1107번
public class Remocon {
    static boolean[] broken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        // 고장난 버튼이 있을 경우 (조건을 걸지않으면 st 가 null 포인트 에러)
        if(N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int index = Integer.parseInt(st.nextToken());
                broken[index] = true;
            }
        }

        // 100에서 타겟 수 까지  +-만 눌러서 도달
        int ans = Math.abs(num - 100);

        // +- 50만 이기 때문에
        for(int i=0; i<1000000; i++){
            // i를 숫자버튼으로 이동할수 있는지, 눌러야하는 버튼의 수
            int len = Solution(i);
            // len 0 이면 숫자 버튼으로 이동 불가능 : 계산 대상 x
            // len != 0 이면 숫자 버튼으로 이동 가능 해당 수와 타겟 차이를 통해서 계산
            if(len != 0){
                int cnt = Math.abs(i - num);
                ans = Math.min(ans, (cnt + len));
            }
        }
        System.out.println(ans);
    }

    private static int Solution(int n){
        int len=0;
        if(n == 0){
            if(broken[0])
                len = 0;
            else{
                len = 1;
            }
            return len;
        }
        while(n > 0){
            if(broken[n%10]){
                len = 0;
                return len;
            }
            len++;
            n /= 10;
        }
        return len;
    }
}