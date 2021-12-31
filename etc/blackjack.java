package blackjack;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class blackjack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		ArrayList<Integer> card = new ArrayList<Integer>();
		
		//입력
		System.out.println("N과 M을 입력하시오.");
		String[] line = bf.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int tmp = 0;
		int res = 0;
		
		System.out.println("N개의 카드덱을 입력하시오.");
		String[] line1 = bf.readLine().split(" ");
		
		for(int i=0; i<N;i++)
			card.add(Integer.parseInt(line1[i]));
		
		//출력
		for(int i = 0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					tmp=card.get(i)+card.get(j)+card.get(k);
					
					if(res < tmp && tmp <= M) {
						res = tmp;
					}
				}				
			}
		}
		System.out.println(res);
	}
}
