package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 5 문제 - 14003번
public class LIS5 {

    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> listForSize = new ArrayList<>();
        listForSize.add(Integer.MIN_VALUE);

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] indexs = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            if(listForSize.get(listForSize.size()-1) < arr[i]) {
                listForSize.add(arr[i]);
                indexs[i] = listForSize.size() - 1;
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
                indexs[i] = right;
            }
        }
        System.out.println(listForSize.size() - 1);

        int index = listForSize.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--) {
            if(indexs[i] == index) {
                index--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}