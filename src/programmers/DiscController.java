package programmers;
import java.util.*;

// 프로그래머스 - 디스크 컨트롤러 문제
class Process implements Comparable<Process>{
    int start;
    int cost;

    public Process(int start, int cost) {
        this.start = start;
        this.cost = cost;
    }

    public int compareTo(Process other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class DiscController {
    public int solution(int[][] jobs) {
        boolean[] visited = new boolean[jobs.length];
        ArrayList<Process> list = new ArrayList<>();

        // 시작 위치가 빠른순, 소요시간이 짧은 순으로 정렬 - current의 첫번째 값 셋팅을 위해서
        Arrays.sort(jobs, (job1,job2)->{
            if(job1[0]==job2[0])
                return Integer.compare(job1[1],job2[1]);
            else
                return Integer.compare(job1[0],job2[0]);
        });

        PriorityQueue<Process> pq = new PriorityQueue<>();
        pq.offer(new Process(jobs[0][0], jobs[0][1]));
        visited[0] =true;

        int current = jobs[0][0]; // 처음 실행되는 작업 시작 시간이 0 이 아닌 경우를 위해서 셋팅
        int sumTime = 0; // 각 작업의 대기부터 완료까지의 시간 합
        int visitNum = 1; // 우선순위 큐에 들어온 작업의 수

        // 큐가 비어 있지않거나 큐에 들어온 작업수가 총 작업수와 같지 않는 경우
        // 앞선 작업이 종료 된 시간에 실행시킬 작업이 없을수도 있기 때문에
        while (!pq.isEmpty() || visitNum != jobs.length) {

            if (!pq.isEmpty()) {
                Process now = pq.poll();
                current += now.cost;
                sumTime += current - now.start;
            }
            // 앞선 작업이 종료 된 시간에 실행시킬 작업이 없는 경우 현 시간을 +1
            else {
                current += 1;
            }

            // 작업 리스트를 순회
            for (int i = 0; i < jobs.length; i++) {
                // 이미 큐에 담긴 작업인 경우
                if (visited[i]) continue;

                // 아직 큐에 담기지 않은 작업 중 현시간보다 시작요청시간이 작은 경우
                if (current >= jobs[i][0]) {
                    visited[i] = true;
                    pq.offer(new Process(jobs[i][0], jobs[i][1]));
                    visitNum += 1;
                }
            }
        }
        return sumTime / jobs.length;
    }
}
