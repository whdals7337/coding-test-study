package greedy;

import java.util.Arrays;

public class GreedyTest1_1 {

	public static void main(String[] args) {
		int result = 0;
		// 배열의 크기, 더해지는 횟수, 연속 가능 횟수
		int size = 5 , count = 8, limit = 3;

		// 입력받은 배열
		int[] list = {2,4,5,4,6};

		//시작하는 시점 계산 ------------------------------------------
		long start = System.currentTimeMillis();

		// 배열 정렬
		Arrays.sort(list);

		// 각장 큰수와 두번째로 큰수 계산
		int first =  list[size-1];
		int second = list[size-2];

		while(true) {
			// 가장 큰수를 연속 가능 횟수 만큼 더하기
			for(int i = 0; i<limit; i++) {

				// 더해지는 횟구가 0에 도달하면 for문을 빠져나옴
				if(count == 0) break;

				result += first;
				count--;
			}

			// 더해지눈 횟수가 0에 도달하면 while문을 빠져나옴
			if(count == 0) break;

			// 두번째로 큰수 더하기
			result += second;
			count--;
		}

		//답안 출력
		System.out.println(result);

		//프로그램이 끝나는 시점 계산--------------------------------------
		long end = System.currentTimeMillis();

		//실행 시간 계산 및 출력
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
	}
}
