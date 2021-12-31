package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class coin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		Scanner scan = new Scanner(System.in);
		int money, min;
		
		//거스름돈 입력
		System.out.println("거스름돈을 입력하시오.");
		money = scan.nextInt();
		
		//동전 종류 입력
		System.out.println("동전 종류를 입력하시오. (단, 1원은 반드시 포함 할 것)");
		String[] line = bf.readLine().split(" ");
		
        int len = line.length;
        int[] coin = new int[len];
        int[] change = new int[money];

        //삽입
        for(int i=0; i<len;i++)
            coin[i] = Integer.parseInt(line[i]);
        
        //동전 있는 경우, 1로 초기화
        for(int i=0; i<len; i++)
        	change[coin[i]-1]=1;
        
        //DP
        for(int i=0; i<money; i++) {
        	min = 9999;
        	if(change[i] == 0) { //직접적인 동전의 액면가가 아닌 경우
        		for(int j=0; j<len; j++) {
        			if(i+1 - coin[j] > 0) { //거스름돈에서 동전을 뺏을 때 양수인 경우
        				int flag = i+1-coin[j]; //거스름돈에서 동전의 액면가를 뺀 값
        				min = (change[flag-1] < min) ? change[flag-1] : min; //동전의 액면가를 뺀 값에 대한 거스름돈 중 최소값을 찾음
        			}
        		}
        		change[i] = min+1; //최소값의 +1 (돈전의 액면가)를 더한 게 해당 거스르돈의 최솟값
        	}
        }
        
        for(int i=0;i<money;i++)
        	System.out.println(change[i]);        
	}
}
