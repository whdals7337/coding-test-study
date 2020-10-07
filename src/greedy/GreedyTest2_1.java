package greedy;

import java.util.Arrays;

public class GreedyTest2_1 {

	public static void main(String[] args) {
		// 숫자 카드 게임
		// 행, 열
		int n = 2, m =4;
		int[][] list = {
				{7,3,1,8},
				{3,3,3,4}
		};

		//시작하는 시점 계산 ------------------------------------------
		long start = System.currentTimeMillis();

		// 작은 수 배열
		int [] resultList = new int[n];

		// 행 반복
		for (int i = 0; i < n; i++ ) {
			int [] temp = new int[m];

			// 열 반복
			for(int j=0; j<m; j++) {
				// 특정 행을 하나의 배열로 만듬
				temp[j] = list[i][j];
			}
			// 각 행별 정렬
			Arrays.sort(temp);

			// 행의 가장 작은 수 작은 수 배열에 작성
			resultList[i] = temp[0];
		}
		// 작은 수 배열 정렬
		Arrays.sort(resultList);

		// 답안 출력
		System.out.println(resultList[n-1]);

		//프로그램이 끝나는 시점 계산--------------------------------------
		long end = System.currentTimeMillis();

		//실행 시간 계산 및 출력
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
	}

}
