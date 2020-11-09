package binary_search;

import java.util.ArrayList;
import java.util.Collections;

// 2020 카카오 신입 공채 1차 - 가사 검색
class BinarySearchTest7 {

    // 리스트 중 타겟과 같거나 뒤에 있는 index 리턴
    public static int lowerBound (ArrayList<String> arr ,String target, int start, int end){
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 리스트 중 타겟보다 뒤에 있는 index 리턴
    public static int upperBound (ArrayList<String> arr ,String target, int start, int end){
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    // 특정 두 문자열사이에 속한 가사 단어 개수 리턴
    public static int range(ArrayList<String> arr, String leftValue, String rightValue){
        int right = upperBound(arr, rightValue, 0, arr.size());
        int left = lowerBound(arr, leftValue, 0, arr.size());
        return  right - left;
    }

    // 문자 리스트
    public static ArrayList<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
    // reverse 문자 리스트
    public static ArrayList<ArrayList<String>> reversedList = new ArrayList<ArrayList<String>>();

    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        // word의 최대 10,000이하 문자열이므로 문자열의 길이 별로 리스트를 따로 둠
        for(int i = 0; i < 10001; i++){
            wordList.add(new ArrayList<String>());
            reversedList.add(new ArrayList<String>());
        }

        // 가사에 속한 문자들을 리스트, reverse 리스트에 담음
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            wordList.get(word.length()).add(word);
            word = (new StringBuffer(word)).reverse().toString();
            reversedList.get(word.length()).add(word);
        }

        // 이진 검색을 위한 정렬
        for(int i = 0; i < 10001; i++){
            Collections.sort(wordList.get(i));
            Collections.sort(reversedList.get(i));
        }

        for(int i = 0; i < queries.length; i++){
            String keyword = queries[i];
            int res = 0;

            // 키워드가 ? 시작 하지않는 경우
            if(keyword.charAt(0) != '?'){
                res = range(wordList.get(keyword.length()), keyword.replaceAll("\\?", "a"), keyword.replaceAll("\\?", "z"));
            }
            // 키워드가 ?로 시작하는 경우
            else {
                // 키워드를 뒤집어서 검색
                keyword = (new StringBuffer(keyword)).reverse().toString();
                res = range(reversedList.get(keyword.length()), keyword.replaceAll("\\?", "a"), keyword.replaceAll("\\?", "z"));
            }
            ans.add(res);
        }

        // arrayList 를 int 배열로 전환
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}