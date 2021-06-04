package programmers;

import java.util.ArrayList;
import java.util.HashMap;

// 프로그래머스 압축 문제
class Compression {

    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static char[] arr;
    static int idx = 1;
    public int[] solution(String msg) {
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        arr = msg.toCharArray();

        while(idx <= arr.length) {
            String tmp;
            if(idx == arr.length) tmp = String.valueOf(arr[idx-1]);
            else tmp = String.valueOf(arr[idx - 1]) + arr[idx];
            encoding(tmp);
        }

        int[] answer = new int[list.size()];
        int size = 0;
        for(int i : list) {
            answer[size++] = i;
            System.out.print(i + " ");
        }
        return answer;
    }
    static void encoding(String tmp) {
        int ans = 0;
        idx++;
        // 현재 문자열이 사전에 등록되었으며 남은 문자열이 있는 경우
        if(map.containsKey(tmp) && idx < arr.length) {
            encoding(tmp + arr[idx]); // 다음 문자까지 확인
        }
        // 사전에 등록되어 있으면서 남은 문자열이 없는 경우
        else if(map.containsKey(tmp)){
            idx++; // 마지막 문자만 따로 계산하지 않도록 idx를 범위 밖으로
            list.add(map.get(tmp));
        }
        // 사전에 등록 되지 않은 경우
        else {
            map.put(tmp, map.size() + 1);
            tmp = tmp.substring(0, tmp.length() - 1);

            list.add(map.get(tmp));
        }
    }
}