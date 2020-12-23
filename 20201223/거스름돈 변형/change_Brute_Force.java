package change_money2;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class change_Brute_Force {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Integer> m_type = new ArrayList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		System.out.print("변환할 돈의 총액을 입력하시오 : ");
		int money = Integer.parseInt(bf.readLine());
		
		System.out.print("동전 종류를 입력하시오 (단, 1원은 무조건 포함 시킬 것) : ");
		String[] line = bf.readLine().split(" ");
		
		for(int i=0; i<line.length;i++)
			m_type.add(Integer.parseInt(line[i]));
		
		Collections.sort(m_type);  //오름차순 정렬
		
		for(int i=m_type.size()-1; i>=0;i--) {
			int m = money;
			int tmp=-1;
			int flag=0;

			for(int j=i;j>=0;j--) {
				if(m >=m_type.get(j)) {
					tmp = m/m_type.get(j);
					flag += tmp;
					m %= m_type.get(j);	
				}
			}
			count.add(flag);
		}
		
		Collections.sort(count);
		System.out.println(count.get(0));
		
	}

}
