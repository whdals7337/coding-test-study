package programmers;

// 프로그래머스 조이스틱 문제
class JoyStick {
    static int count(char target) {
        int front = Math.abs(target - 'A');
        int back = 'Z' - target + 1;
        return Math.min(front, back);
    }

    public int solution(String name) {
        int answer = 0;
        int cursor = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            answer += count(name.charAt(i));
        }

        for(int i = 0; i <name.length(); i++) {
            int next = i+1;

            while(next < name.length() && name.charAt(next) == 'A') {
                next+=1;
            }

            // i 다음부터 A의 갯수
            int As = next - i - 1;

            // 전체에서 A를 제외하고 움직이는 횟수
            int moveWithoutA = name.length() - As - 1;

            // 처음부터 i번째 까지 왔다가 돌아가는 방식과 처음에 맨뒤로 갔다가 다시 i번째 까지 오는 방식중 작은 값
            int min = Math.min(i, name.length() - next);

            // 돌아가는거 없이 정방향으로 움직인 경우와 name의 각 위치마다 움직여야하는 커서 수들 중 작은 값
            cursor = Math.min(cursor, moveWithoutA + min);
        }
        // 각 자리수를 만들기위해서 필요한 조작 횟수 + 좌우를 최소한으로 조작하는 수
        return answer + cursor;
    }
}