package LimKangHyun.week10;

import java.util.*;
// 구간 커버
public class 단속카메라 {

	/**
	 * 시간복잡도(BigO) : O(NlogN)
	 * 차량의 진출 시점 기준으로 정렬하여,
	 * 현재 카메라 설치 지점 이후로 진입하는 차량마다 새로운 카메라를 설치하는 방식
	 *
	 * - 차량의 진출 지점 기준으로 정렬
	 * - 현재 카메라 설치 지점(cam)이 차량 진입 시점보다 이전이라면 새로운 카메라 설치
	 * - 차량마다 위 과정을 반복하여 최소 카메라 개수를 구함
	 */
	public int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
		int cam = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (cam < route[0]) {
				answer++;
				cam = route[1];
			}
		}
		return answer;
	}
}
