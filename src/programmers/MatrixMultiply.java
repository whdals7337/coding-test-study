package programmers;

// 프로그래머스 행렬의 곱셈 문제
class MatrixMultiply {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int fLen = arr1.length;
        int sLen = arr2[0].length;
        int colLen = arr2.length;

        int[][] answer = new int[fLen][sLen];
        for (int i = 0; i < fLen; i++) {
            for (int j  = 0; j < sLen; j++) {
                for (int k = 0; k < colLen; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}