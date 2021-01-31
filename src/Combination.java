
import java.util.ArrayList;

public class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        // r 개를 뽑은 경우 모드 조합 리스트에 추가
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }

        // 뽑을 인덱스 값이 n과 같아지면 리스트 끝에 도달했다는 의미
        if (target == n) return;

        // 인덱스 값에 셋팅해놓음 -> 뽑지 않는 경우 index 값을 변경하지 않기 때문에 다음에 값이 변경됨
        now[index] = target;

        // 뽑는 경우
        combination(arr, depth + 1, index + 1, target + 1);

        // 뽑지 않는 경우
        combination(arr, depth, index, target + 1);
    }

    class Position{
        private int x;
        private int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
