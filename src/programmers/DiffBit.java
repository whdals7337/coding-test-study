package programmers;

// 프로그래머스 2개 이하로 다른 비트 문제
class DiffBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;

            } else {
                StringBuilder temp = new StringBuilder();
                String binaryString = Long.toBinaryString(numbers[i]);
                if (!binaryString.contains("0")) {
                    // 맨 앞을 10으로
                    temp.append("10");

                    // 나머지 자리수를 모두 1로
                    temp.append(binaryString.substring(1).replace("0", "1"));

                } else {
                    int lastIndex = binaryString.lastIndexOf("0");
                    int firstOneIndex = binaryString.indexOf("1", lastIndex);
                    // 마지막 0을 1로 수정
                    temp.append(binaryString, 0, lastIndex).append("1");

                    // 마지막 0 다음 1을 0으로 수정
                    temp.append("0");

                    // 그 다음 비트열
                    temp.append(binaryString.substring(firstOneIndex + 1));
                }
                answer[i] = Long.parseLong(temp.toString(), 2);
            }
        }
        return answer;
    }
}