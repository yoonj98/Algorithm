package sorting2;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sorting2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		
		//입력
		System.out.println("정렬할 데이터를 입력하시오.(구분자 : 스페이스)");
		String[] line = bf.readLine().split(" ");
		int len = line.length;
		
		int[] arr=new int[len];

		for(int i=0; i<len;i++)
			arr[i] = Integer.parseInt(line[i]);
		
		//힙정렬
		System.out.println("case : 힙정렬");
		print(arr);
		heap_sort(arr);
		print(arr);
	}
	
	static void print(int[] array){
		for(int i=0; i<array.length;i++) 
			System.out.print(array[i]+"  ");
		System.out.println();
	}
	
	static void heap(int[] arr, int index) {
		int len, max, right, left;
		len=arr.length;
		max=index;
		left=2*index+1;
		right=2*index+2;
		
		if(left<len && arr[left]>arr[max]) 
			max=left;
		if(right<len && arr[right] > arr[max])
			max=right;
		if(max != index) {
			int tmp;
			tmp=arr[index];
			arr[index]=arr[max];
			arr[max]=tmp;		
			print(arr);
			heap(arr, max);
		}		
	}
	
	static void heap_sort(int[] arr) {
		int len=arr.length;
		for(int i=len/2-1; i>-1; i--)
			heap(arr, i);
		for(int i=len-1; i>0; i--) {
			int tmp=arr[0];
			arr[0]=arr[i];
			arr[i]=tmp;
			print(arr);
			heap(arr, 0);
		}	
	}
}
