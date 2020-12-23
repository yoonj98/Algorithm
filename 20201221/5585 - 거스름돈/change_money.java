package change_money;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 5585번 : 거스름돈

public class change_money {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		int num = Integer.parseInt(bf.readLine()); //string to integer
		int money=1000-num;
		int m_500=0;
		int m_100=0;
		int m_50=0;
		int m_10=0;
		int m_5=0;
		int m_1=0;
		
		if(money>=500) {
			m_500=money/500;
			money %=500;
		}
		if(money>=100) {
			m_100=money/100;
			money %=100;
		}
		if(money>=50) {
			m_50=money/50;
			money %=50;
		}
		if(money>=10) {
			m_10=money/10;
			money %=10;
		}
		if(money>=5) {
			m_5=money/5;
			money %=5;
		}
		if(money>=1) {
			m_1=money/1;
			money %=1;
		}

		System.out.println(m_500+m_100+m_50+m_10+m_5+m_1);
	}
}
