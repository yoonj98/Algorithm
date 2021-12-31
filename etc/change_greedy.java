package change_money2;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class change_greedy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> m_type = new ArrayList<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		System.out.print("��ȯ�� ���� �Ѿ��� �Է��Ͻÿ� : ");
		int money = Integer.parseInt(bf.readLine());
		int count = 0;
		
		System.out.print("���� ������ �Է��Ͻÿ� (��, 1���� ������ ���� ��ų ��) : ");
		String[] line = bf.readLine().split(" ");
		
		for(int i=0; i<line.length;i++)
			m_type.add(Integer.parseInt(line[i]));
		
		Collections.sort(m_type);  //�������� ����

		for(int i=m_type.size()-1; i>=0; i--) {
			if(money >=m_type.get(i)) {
				int tmp = money/m_type.get(i);
				count += tmp;
				money %= m_type.get(i);	
			}
		}
		
		System.out.println(count);
		
	}

}
