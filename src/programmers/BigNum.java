package programmers;

import java.util.Arrays;

// 프로그래머스 가장 큰 수 문제
class BigNum {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        String[] nums = new String[numbers.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = numbers[i] + "";
        }
        // 두 수를 앞 뒤로 합친 경우를 내림차순으로
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // 정렬된 수를 추가
        for(String num : nums) {
            sb.append(num);
        }
        // 만약 모든 숫자가 0이라면 0000 이런 문자가 됨
        // 그래서 맨앞에가 0인 경우 0으로 리턴
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}