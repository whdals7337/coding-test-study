package realization;

// 2020 카카오 신입 공채 - 자물쇠와 열쇠 문제
public class RealizationTest8 {
    
    // 90도 회전
    public int[][] rotate90Degree(int[][] key){
        int n = key.length;
        int m = key[0].length;

        int[][] result = new int[n][m];

        for(int i =0; i < n; i++){
            for(int j =0; j < m; j++){
                result[j][n-1-i] = key[i][j];
            }
        }
        return result;
    }

    // 자물쇠 중간 영역 확인
    public boolean check(int[][] newLock){
        int num = newLock.length / 3;

        for(int i = num; i < num * 2; i++){
            for(int j =num; j < num * 2; j++){
                if(newLock[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        // 기존 자물쇠의 3배 크기 셋팅
        int[][] newLock = new int[n * 3][n * 3];

        // 새 자물쇠의 가운데에 기존 자물쇠 넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                newLock[i+n][j+n] = lock[i][j];
            }
        }

        // 키를 90도씩 360도(4번) 돌려가면서 자물쇠에 끼어 넣고 맞물리는지 확인
        for(int k = 0; k < 4; k++){
            key = rotate90Degree(key);

            for(int i = 0; i < n * 2; i++){
                for(int j = 0; j < n * 2; j++){
                    // 자물쇠에 키 끼워 넣기
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            newLock[i+x][j+y] += key[x][y];
                        }
                    }

                    // 열쇠가 맞은 경우
                    if(check(newLock)) return true;

                    // 열쇠가 맞지 않는 경우
                    else {
                        // 자물쇠에서 키 빼기
                        for(int x = 0; x < m; x++){
                            for(int y = 0; y < m; y++){
                                newLock[i+x][j+y] -= key[x][y];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
