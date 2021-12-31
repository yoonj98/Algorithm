package B_664;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_664 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
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

	            
	            for (int i = 0; i < num; i++) {  //행성 초기화
	                st = new StringTokenizer(bf.readLine());
	                
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                int radius = Integer.parseInt(st.nextToken());

	                
	                int check1 = 0;  //출발점 위치 - 0=안, 1=밖
	                int check2 = 0;  //도착점 위치 - 0=안, 1=밖

	                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(radius, 2)) 
	                	check1 = 1;
	                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) > Math.pow(radius, 2)) 
	                	check2 = 1;

	                
	                if(check1 == 1 && check2 == 0) // 시작점, 도착점 둘 중에 하나만 안에 있을 때
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