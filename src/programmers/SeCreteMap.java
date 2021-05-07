package programmers;

// 프로그래머스 비밀지도 문제
class SeCreteMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0 ; i < n; i++) {
            String s1 = staticLengthBinaryString(n, arr1[i] | arr2[i]);
            answer[i] = toShapString(s1);
        }
        return answer;
    }

    public String staticLengthBinaryString(int length, int number) {
        String binaryString = Integer.toBinaryString(number);
        StringBuilder temp = new StringBuilder();
        for(int i = 1; i <= length - binaryString.length(); i++) {
            temp.append("0");
        }
        return temp.append(binaryString).toString();
    }

    static String toShapString(String str) {
        return str.replace("1", "#").replace("0", " ");
    }
}