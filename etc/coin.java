package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class coin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		Scanner scan = new Scanner(System.in);
		int money, min;
		
		//�Ž����� �Է�
		System.out.println("�Ž������� �Է��Ͻÿ�.");
		money = scan.nextInt();
		
		//���� ���� �Է�
		System.out.println("���� ������ �Է��Ͻÿ�. (��, 1���� �ݵ�� ���� �� ��)");
		String[] line = bf.readLine().split(" ");
		
        int len = line.length;
        int[] coin = new int[len];
        int[] change = new int[money];

        //����
        for(int i=0; i<len;i++)
            coin[i] = Integer.parseInt(line[i]);
        
        //���� �ִ� ���, 1�� �ʱ�ȭ
        for(int i=0; i<len; i++)
        	change[coin[i]-1]=1;
        
        //DP
        for(int i=0; i<money; i++) {
        	min = 9999;
        	if(change[i] == 0) { //�������� ������ �׸鰡�� �ƴ� ���
        		for(int j=0; j<len; j++) {
        			if(i+1 - coin[j] > 0) { //�Ž��������� ������ ���� �� ����� ���
        				int flag = i+1-coin[j]; //�Ž��������� ������ �׸鰡�� �� ��
        				min = (change[flag-1] < min) ? change[flag-1] : min; //������ �׸鰡�� �� ���� ���� �Ž����� �� �ּҰ��� ã��
        			}
        		}
        		change[i] = min+1; //�ּҰ��� +1 (������ �׸鰡)�� ���� �� �ش� �Ž������� �ּڰ�
        	}
        }
        
        for(int i=0;i<money;i++)
        	System.out.println(change[i]);        
	}
}
