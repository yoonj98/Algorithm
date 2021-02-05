package NQueen;

import java.util.*;

/* #체스 규칙
 * Queen : 상하좌우 + 대각선 칸 상관없이 일직선으로 이동 가능
 * 
 * #아이디어
 * 한 행에 한 개의 queen만 존재함 >> 각 행별로 queen이 존재하는 좌표만 파악하면 되므로, 2차원 배열을 1차월으로 줄일 수 있음
 * 
 * #조건
 * 1. 이전 행과 동일 열이 없어야 함.
 * 2. 이전 행들과 떨어진 칸 수만큼 차이나면 안됨 (=대각선 위치)
 * 		ex) 0 | 2 | 4 | 1 | 3 (5x5) - 가능
 * 			3 | 0 | 4 | 2 | 1 (5x5) - 불가능 : arr[1](=0)과 arr[3](=2)의 좌표 차가 index(=column)의 차와 동일하므로 대각선에 위치 + arr[3], arr[4]의 좌표 차 역시 index의 차와 동일
 * */

public class NQueen {

	public static int[] arr;	//index : 열, data : 행(좌표)
	public static int N;
	public static int cnt = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		
		//첫번째 행 호출
		n_queen(0);
		System.out.println(cnt);
		
		return;
	}
	
	public static void n_queen(int pos) {
		if(pos == N) {	//마지막 N번째 행까지 무사히 완수
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[pos] = i;	//i번째 열에 queen 위치
			
			if(test(pos))	//i 위치에 두어도 괜찮을 때
				n_queen(pos + 1);	//다음 행 호출		
			
			//괜찮치 않으면 for문이 돌면서 다음 열로 넘어감
		}
	}
	
	public static boolean test(int pos) {
		for(int i=0;i<pos;i++) {	//이전 열들과 검사
			if(arr[pos] == arr[i])	//동일 열에 위치 - 조건 1 위배
				return false;
			else if(arr[pos] == arr[i]+(pos-i))	//조건 2 위배 (현재 위치(행) = 이전 위치(행)과 열의 차이만큼 떨어져 있음)
				return false;
			else if(arr[pos] == arr[i]-(pos-i))	//조건 2 위배
				return false;
		}		
		return true;
	}
}
