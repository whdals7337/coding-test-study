package breadth_first_search;

import java.util.*;

class Virus {
    private int x;
    private int y;
    private int type;

    public Virus(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }
}

// 경쟁적 전염 문제
public class BreathFirstSearchTest4 {

    // 시험관의 크기, 바이러스의 종류의 개수, 타겟 초, 타겟 지역(x, y)
    public static int n, k, s, x ,y;

    public static int[][] map = new int[201][201];

    public static Queue<Virus> q = new LinkedList<>();

    // 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        ArrayList<Virus> list =  new ArrayList<Virus>();

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] > 0){
                    Virus vi = new Virus(i ,j, map[i][j]);
                    list.add(vi);
                }
            }
        }

        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();


        Collections.sort(list, new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return Integer.compare(o1.getType(), o2.getType());
            }
        });

        for(int i = 1; i <= s; i++){

            for(int j = 0; j < list.size(); j++){
                q.offer(list.get(j));
            }

            list.clear();

            while (!q.isEmpty()){
                Virus current = q.poll();
                for(int a = 0; a < 4; a++) {
                    int targetX = current.getX() + dx[a];
                    int targetY = current.getY() + dy[a];

                    // map 을 벗어나지 않는 경우
                    if(targetX > 0 && targetX <= n && targetY > 0 && targetY <= n){
                        // 해당 지역이 바이러스가 걸리지 않은 상태
                        if(map[targetX][targetY] == 0){
                            // 해당 지역에 바이러스를 퍼트리고 해당 지역의 상하좌우를 다음 처리에 추가
                            map[targetX][targetY] = current.getType();
                            list.add(new Virus(targetX, targetY, current.getType()));
                        }
                    }
                }
            }
        }
        System.out.println(map[x][y]);
    }
}
