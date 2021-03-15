package programmers;

import java.util.Arrays;

// 프로그래머스 단속카메라 문제
class Camera {
    public int solution(int[][] routes) {
        // 끝나는 시점으로 정렬
        Arrays.sort(routes, ((o1, o2) -> Integer.compare(o1[1], o2[1])));
        int answer = 0;
        int camera = -30000;

        for(int[] route: routes) {
            // 시작 지점이 카메라 설치 지점보다 뒤에 있으면
            // 끝 지점에 카메라 설치
            if(route[0] > camera) {
                camera = route[1];
                answer+=1;
            }
        }
        return answer;
    }
}