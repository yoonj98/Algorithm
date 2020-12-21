package Fiobo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� - 2749�� : �Ǻ���ġ�� 3
//��Ÿ�� ���� >> �Է°��� ���� - scanner��� BufferedReader �̿�
//�ð��ʰ� >> �ǻ�� �ֱ��̿�
//�ǻ�� �ֱ� : �ֱ��� ���̰� P �̸�, N��° �Ǻ���ġ ���� M���� ���� �������� N%P��° �Ǻ���ġ ���� M�� ���� �������� ����.
//M = 10^k �� �� k > 2 ���, �ֱ� P�� �׻� 15 �� 10^k-1

public class fibo3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int p=1500000; //�ֱ�
		int[] fibo=new int[p];
		
		fibo[0] = 0; 	//�Ǻ���ġ�� num=0�϶�
		fibo[1] = 1;	//�Ǻ���ġ�� num=1�϶�
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		long num = Long.parseLong(bf.readLine()); //string to long
		
		for(int i=2; i<p;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
			fibo[i] %= 1000000;
		}		
		
		System.out.println(fibo[(int)(num%p)]);
	}
}
