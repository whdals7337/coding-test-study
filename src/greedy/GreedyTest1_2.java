package greedy;

import java.util.Arrays;

public class GreedyTest1_2 {

	public static void main(String[] args) {
		// 큰수법칙
		int result = 0;
		// 배열의 크기, 더해지는 횟수, 연속 가능 횟수
		int size = 5 , count = 8, limit = 3;

		// 입력받은 배열
		int[] list = {2,4,5,4,6};

		//시작하는 시점 계산 ------------------------------------------
		long start = System.currentTimeMillis(); //시작하는 시점 계산

		// 배열 정렬
		Arrays.sort(list);

		// 각장 큰수와 두번째로 큰수 계산
		int first =  list[size-1];
		int second = list[size-2];

		// 가장 큰수가 더해지는 횟수 계산
		int cnt = count/(limit + 1) * limit;
		cnt += count%(limit + 1);

		result += cnt * first; // 가장큰 수 계산
		result += (count-cnt) * second; // 두번째로 큰 수 계산

		//답안 출력
		System.out.println(result);

		//프로그램이 끝나는 시점 계산--------------------------------------
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산

		//실행 시간 계산 및 출력
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
	}

}
