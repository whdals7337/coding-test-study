package programmers;

// 프로그래머스 소수 만들기 문제
class MakePrime {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums,0, 0, 0);
        return answer;
    }

    static void dfs(int[] nums, int sum, int count, int idx) {
        if(count == 3) {
            if (isPrime(sum)) {
                answer++;
            }
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(nums, sum + nums[i], count + 1, i);
                visited[i] = false;
            }
        }
    }

    static Boolean isPrime(int num){
        int cnt = 0;
        for(int i = 1; i <= (int)Math.sqrt(num); i ++){
            if(num % i == 0) cnt += 1;
        }
        return cnt == 1;
    }
}