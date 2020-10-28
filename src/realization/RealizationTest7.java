package realization;

// 2020 카카오 신입 공채 - 문자열 압축 문제
public class RealizationTest7 {
    public int solution(String s) {
        int answer = s.length();

        // step(압축단위)를 늘려가면서 확인
        for(int step = 1; step < s.length()/2+1; step++){
            String compressedStr = "";
            String prev = s.substring(0, step);
            int cnt = 1;

            // 문자열의 step 부터 step 만큼 늘려가면서 확인
            for(int i = step; i < s.length(); i += step){
                String sub ="";

                // step 단위로 다음 문자열을 땜
                for(int j = i; j < i+step; j++){
                    if(j < s.length()) sub += s.charAt(j);
                }

                // 압축 문자열과 땐 문자열이 같은 경우
                if(prev.equals(sub)){
                    cnt +=1;
                }
                // 압축 문자열과 땐 문자열이 다른 경우
                else {
                    compressedStr += (cnt >= 2) ? cnt + prev : prev;

                    sub = "";
                    for(int j = i; j < i+step; j++){
                        if(j < s.length()) sub += s.charAt(j);
                    }

                    prev = sub;
                    cnt = 1;
                }
            }
            // 남은 문자열 처리 (마지막에 압축 문자열과 땐 문자열이 같은경우 압축 과정을 거치지 않기 때문에 여기서 처리)
            compressedStr += (cnt >=2) ? cnt + prev : prev;

            // 이전 압축문자열의 길이와 이번 압축 문자열의 길이 중 작은 값
            answer = Math.min(answer, compressedStr.length());
        }
        return answer;
    }
}
