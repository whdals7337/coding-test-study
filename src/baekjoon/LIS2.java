package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2 문제 - 12015번
public class LIS2 {

    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> listForSize = new ArrayList<>();
        listForSize.add(0);

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++) {
            if(listForSize.get(listForSize.size()-1) < arr[i]) {
                listForSize.add(arr[i]);
            }
            else {
                int left = 1;
                int right = listForSize.size()-1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if(listForSize.get(mid) < arr[i]) {
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                listForSize.set(right, arr[i]);
            }
        }
        System.out.println(listForSize.size() - 1);
    }
}