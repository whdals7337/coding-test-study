package programmers;

// 프로그래머스 단어변환 문제
class ChangeWord {
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        // target 이 words 안에 있는지 경우
        if(isContain(target, words)) {
            boolean[] visited = new boolean[words.length];
            dfs(begin, target, words, visited, 0);
        }
        // target 이 words 안에 없는 경우
        else {
            answer = 0;
        }
        return answer;
    }


    static boolean isContain(String target, String[] words) {
        for(String word : words) {
            if(word.equals(target)) return true;
        }
        return false;
    }

    static void dfs(String temp, String target, String[] words, boolean[] visited, int count) {
        // temp 값과 타겟이 같은 경우
        if(temp.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            int diff = 0; // temp 값과 word 의 차이 수
            for(int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }

            // 차이가 1개 나고 방문한적 없는 경우
            if(diff == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}