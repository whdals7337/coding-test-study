package programmers;

class InstallStation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int position = 1;

        while(position <= n) {
            // 현재 확인하고자 하는 위치가 특정 기지국과 겹치는 경우
            if(stationIdx < stations.length && position >= stations[stationIdx] - w){
                position = stations[stationIdx] + w + 1;
                stationIdx++;
            }else {
                answer++;
                position += w * 2 + 1;
            }
        }
        return answer;
    }
}