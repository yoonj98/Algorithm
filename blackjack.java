package blackjack;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class blackjack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		ArrayList<Integer> card = new ArrayList<Integer>();
		
		//�Է�
		System.out.println("N�� M�� �Է��Ͻÿ�.");
		String[] line = bf.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int tmp = 0;
		int res = 0;
		
		System.out.println("N���� ī�嵦�� �Է��Ͻÿ�.");
		String[] line1 = bf.readLine().split(" ");
		
		for(int i=0; i<N;i++)
			card.add(Integer.parseInt(line1[i]));
		
		//���
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
