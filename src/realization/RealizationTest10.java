package realization;

import java.util.*;

class build implements Comparable<build>{
    private int x;
    private int y;
    private int type;

    public build(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getType(){
        return this.type;
    }

    public int compareTo(build other){
        if(this.x == other.x && this.y == other.y){
            return Integer.compare(this.type, other.type);
        }
        if(this.x == other.x){
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }

}
// 2020 카카오 신입 공채 - 기둥과 보 설치 문제
class Solution {

    public boolean isPossible(ArrayList<ArrayList<Integer>> list){
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).get(0);
            int y = list.get(i).get(1);
            int type = list.get(i).get(2);

            // 기둥인 경우
            if(type == 0){
                boolean check = false;

                // 바닥 위
                if(y == 0) check = true;

                for(int j = 0; j < list.size(); j++){
                    // 보의 위 인 경우 (보의 경우 지점부터 오른쪽 으로 1까지 보이므로)
                    if(1 == list.get(j).get(2) && x == list.get(j).get(0) + 1 && y == list.get(j).get(1)){
                        check = true;
                    }
                    if(1 == list.get(j).get(2) && x == list.get(j).get(0) && y == list.get(j).get(1)){
                        check = true;
                    }

                    // 다른 기둥의 위 인 경우 (기둥의 경우 지점부터 위로 1까지 기둥이므로)
                    if(0 == list.get(j).get(2) && x == list.get(j).get(0) && y == list.get(j).get(1) + 1 ){
                        check = true;
                    }
                }
                // 기둥 중 하나라도 불가능한 경우 false 리턴
                if(!check) return false;
            }
            // 보 인 경우
            else if(type == 1) {
                boolean check = false;
                boolean left = false;
                boolean right = false;

                for(int k = 0; k < list.size(); k++ ){
                    // 한 쪽 끝이 기둥위 인 경우
                    if(0 == list.get(k).get(2) && x == list.get(k).get(0) && y == list.get(k).get(1) + 1 ){
                        check = true;
                    }
                    if(0 == list.get(k).get(2) && x + 1 == list.get(k).get(0) && y == list.get(k).get(1) + 1 ){
                        check = true;
                    }

                    // 왼쪽 끝이 다른 보와 연결된 경우
                    if( 1 == list.get(k).get(2) && x == list.get(k).get(0) + 1 && y == list.get(k).get(1) ){
                        left = true;
                    }
                    // 오른쪽 끝이 다른 보와 연결된 경우
                    if( 1 == list.get(k).get(2) && x + 1 == list.get(k).get(0) && y == list.get(k).get(1) ){
                        right =true;
                    }
                }
                if(left && right) check = true;
                // 보 중 하나라도 불가능한 경우 false 리턴
                if(!check) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int operate = build_frame[i][3];

            // 등록
            if (operate == 1) {
                // 설치 후
                ArrayList<Integer> Ithing = new ArrayList<Integer>();
                Ithing.add(x);
                Ithing.add(y);
                Ithing.add(type);
                list.add(Ithing);

                // 설치가 가능한 형태인지 확인
                if(!isPossible(list)){
                    list.remove(list.size() -1);
                }
            }
            // 삭제
            else {
                int index = 0;
                // 삭제하고자 하는 대상 탐색
                for(int k =0; k < list.size(); k++){
                    if(x == list.get(k).get(0) && y == list.get(k).get(1) && type == list.get(k).get(2)){
                        index = k;
                    }
                }
                //temp thing
                ArrayList<Integer> Dthing = list.get(index);
                list.remove(index);

                // 설치가 가능한 형태인지 확인
                if (!isPossible(list)){
                    list.add(Dthing);
                }
            }
        }

        // 건축물 정보를 담을 목록
        ArrayList<build> result = new ArrayList<build>();
        for(int i = 0; i < list.size(); i++){
            result.add(new build(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2)));
        }
        // 목록 정렬
        Collections.sort(result);

        // 배열로 변환
        int[][] answer = new int[result.size()][3];
        for(int i =0; i < result.size(); i++){
            answer[i][0] = result.get(i).getX();
            answer[i][1] = result.get(i).getY();
            answer[i][2] = result.get(i).getType();
        }

        return answer;
    }
}
