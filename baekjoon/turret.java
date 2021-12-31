package turret;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class turret {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		int test = Integer.parseInt(bf.readLine());
		
		while (test-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
 
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
 
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			System.out.println(dist(x1, y1, r1, x2, y2, r2));
		}
	}
	
	static int dist(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance=(int)(Math.pow(x2 - x1,2)+Math.pow(y2 - y1,2));
		
		if(distance == 0) {	//���� ������ ��
			if(r1==r2)	//������ ����
				return -1;	//����
			else	//������ �ٸ�
				return 0; //�Ұ���
		}
		else if(distance > Math.pow(r1+r2,2)) //���� �Ÿ� > ������ �Ÿ� ��
			return 0; //���� x
		else if(distance == Math.pow(r1+r2,2))  //���� �Ÿ� == ������ �Ÿ� ��
			return 1; //����
		else if(distance < Math.pow(r1-r2,2))
			return 0; //���� X
		else if(distance == Math.pow(r1-r2,2))
			return 1; //����
		else 
			return 2;
	}
}
