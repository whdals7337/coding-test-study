package programmers;

import java.util.ArrayList;
import java.util.Collections;

// 프로그래머스 여행경로 문제
class Travel {

    static boolean[] ticketUsed; // 티켓 사용 여부
    static ArrayList<String> result; // 티켓을 사용하는 경로의 경우의 수

    public String[] solution(String[][] tickets) {
        ticketUsed = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);

        // 모든 경로를 정렬
        Collections.sort(result);

        // 첫번재 경로을 잘라서 리턴
        return result.get(0).split(" ");
    }

    static void dfs(String now, String nodes, int count, String[][] tickets) {
        // 사용한 티켓의 수가 전체 티켓의 수와 같아진 경우
        if(count == tickets.length) {
            result.add(nodes);
            return;
        }

        // 티켓 배열을 순회
        for(int i = 0; i < tickets.length; i++) {
            // 티켓을 아직 사용하지 않았고 해당 티켓의 출발지가 현재 위치와 같은 경우
            if(!ticketUsed[i] && tickets[i][0].equals(now)) {
                // 티켓을 사용하고 이동
                ticketUsed[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1],count+1, tickets);
                ticketUsed[i] = false;
            }
        }
    }
}