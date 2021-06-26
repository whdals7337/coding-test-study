package programmers;

// 프로그래머스 서울에서 김서방 찾기 문제
class FindKim {
    public String solution(String[] seoul) {
        int kimIdx = getTargetNameIdx(seoul,"Kim");
        return new StringBuffer().append("김서방은 ").append(kimIdx).append("에 있다").toString();
    }

    int getTargetNameIdx(String[] names, String targetName) {
        int idx = 0;
        for (String name : names) {
            if (name.equals(targetName)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}