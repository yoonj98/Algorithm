package turret;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class turret {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
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
		
		if(distance == 0) {	//동일 지점일 때
			if(r1==r2)	//반지름 같음
				return -1;	//무한
			else	//반지름 다름
				return 0; //불가능
		}
		else if(distance > Math.pow(r1+r2,2)) //중점 거리 > 반지름 거리 합
			return 0; //존재 x
		else if(distance == Math.pow(r1+r2,2))  //중점 거리 == 반지름 거리 합
			return 1; //외접
		else if(distance < Math.pow(r1-r2,2))
			return 0; //존재 X
		else if(distance == Math.pow(r1-r2,2))
			return 1; //내접
		else 
			return 2;
	}
}
