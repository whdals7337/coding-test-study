package greedy;

public class GreedyTest2_2 {

	public static void main(String[] args) {
		// 숫자 카드 게임
		int result = 0;
		// 행, 열
		int n = 2, m =4;
		int[][] list = {
				{7,3,1,8},
				{3,3,3,4}
		};

		//시작하는 시점 계산 ------------------------------------------
		long start = System.currentTimeMillis();

		// 행 반복
		for (int i = 0; i < n; i++ ) {
			// 가장 작은 값 설정 (값제한이 10000 이므로 10001로 설정)
			int minValue = 10001;

			// 행의 가장 작은값 구함
			for(int j=0; j<m; j++) {
				minValue = Math.min(minValue, list[i][j]);
			}

			// 행을 반복하면서 가장 작은 값들 중 큰값을 구함
			result = Math.max(result, minValue);

		}

		// 답안 출력
		System.out.println(result);

		//프로그램이 끝나는 시점 계산--------------------------------------
		long end = System.currentTimeMillis();

		//실행 시간 계산 및 출력
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
	}

}
