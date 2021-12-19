package NQueen;

import java.util.*;

/* #ü�� ��Ģ
 * Queen : �����¿� + �밢�� ĭ ������� ���������� �̵� ����
 * 
 * #���̵��
 * �� �࿡ �� ���� queen�� ������ >> �� �ະ�� queen�� �����ϴ� ��ǥ�� �ľ��ϸ� �ǹǷ�, 2���� �迭�� 1�������� ���� �� ����
 * 
 * #����
 * 1. ���� ��� ���� ���� ����� ��.
 * 2. ���� ���� ������ ĭ ����ŭ ���̳��� �ȵ� (=�밢�� ��ġ)
 * 		ex) 0 | 2 | 4 | 1 | 3 (5x5) - ����
 * 			3 | 0 | 4 | 2 | 1 (5x5) - �Ұ��� : arr[1](=0)�� arr[3](=2)�� ��ǥ ���� index(=column)�� ���� �����ϹǷ� �밢���� ��ġ + arr[3], arr[4]�� ��ǥ �� ���� index�� ���� ����
 * */

public class NQueen {

	public static int[] arr;	//index : ��, data : ��(��ǥ)
	public static int N;
	public static int cnt = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		
		//ù��° �� ȣ��
		n_queen(0);
		System.out.println(cnt);
		
		return;
	}
	
	public static void n_queen(int pos) {
		if(pos == N) {	//������ N��° ����� ������ �ϼ�
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[pos] = i;	//i��° ���� queen ��ġ
			
			if(test(pos))	//i ��ġ�� �ξ ������ ��
				n_queen(pos + 1);	//���� �� ȣ��		
			
			//����ġ ������ for���� ���鼭 ���� ���� �Ѿ
		}
	}
	
	public static boolean test(int pos) {
		for(int i=0;i<pos;i++) {	//���� ����� �˻�
			if(arr[pos] == arr[i])	//���� ���� ��ġ - ���� 1 ����
				return false;
			else if(arr[pos] == arr[i]+(pos-i))	//���� 2 ���� (���� ��ġ(��) = ���� ��ġ(��)�� ���� ���̸�ŭ ������ ����)
				return false;
			else if(arr[pos] == arr[i]-(pos-i))	//���� 2 ����
				return false;
		}		
		return true;
	}
}
