package Fiobo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 2749번 : 피보나치수 3
//런타임 에러 >> 입력값의 범위 - scanner대신 BufferedReader 이용
//시간초과 >> 피사노 주기이용
//피사노 주기 : 주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같다.
//M = 10^k 일 때 k > 2 라면, 주기 P는 항상 15 × 10^k-1

public class fibo3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int p=1500000; //주기
		int[] fibo=new int[p];
		
		fibo[0] = 0; 	//피보나치수 num=0일때
		fibo[1] = 1;	//피보나치수 num=1일때
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		long num = Long.parseLong(bf.readLine()); //string to long
		
		for(int i=2; i<p;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
			fibo[i] %= 1000000;
		}		
		
		System.out.println(fibo[(int)(num%p)]);
	}
}
