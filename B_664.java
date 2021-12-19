package B_664;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_664 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		int test = Integer.parseInt(bf.readLine());
		
		 while(test-- > 0) {
	            int answer = 0;

	            StringTokenizer st = new StringTokenizer(bf.readLine());
	            
	            int startX = Integer.parseInt(st.nextToken());
	            int startY = Integer.parseInt(st.nextToken());
	            int endX = Integer.parseInt(st.nextToken());
	            int endY = Integer.parseInt(st.nextToken());

	            int num = Integer.parseInt(bf.readLine());

	            
	            Planet arr[] = new Planet[num];

	            
	            for (int i = 0; i < num; i++) {  //�༺ �ʱ�ȭ
	                st = new StringTokenizer(bf.readLine());
	                
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                int radius = Integer.parseInt(st.nextToken());

	                
	                int check1 = 0;  //����� ��ġ - 0=��, 1=��
	                int check2 = 0;  //������ ��ġ - 0=��, 1=��

	                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(radius, 2)) 
	                	check1 = 1;
	                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) > Math.pow(radius, 2)) 
	                	check2 = 1;

	                
	                if(check1 == 1 && check2 == 0) // ������, ������ �� �߿� �ϳ��� �ȿ� ���� ��
	                	answer++;
	                else if(check1 == 0 && check2 == 1) 
	                	answer++;
	            }    
	            System.out.println(answer);
		 }		
	}
}

class Planet{
    int x;
    int y;
    int radius;

    public Planet(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}