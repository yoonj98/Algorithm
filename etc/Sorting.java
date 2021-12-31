package sorting;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorting {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

		//입력
		System.out.println("정렬할 데이터를 입력하시오.(구분자 : 스페이스)");
		String[] line = bf.readLine().split(" ");
		
		int[] arr=new int[line.length];

		for(int i=0; i<line.length;i++)
			arr[i] = Integer.parseInt(line[i]);
		
		//선택 정렬
		select_sort(arr);
		System.out.println();
		
		//삽입 정렬
		insert_sort(arr);
		System.out.println();
		
		//쉘 정렬
		shell_sort(arr);	
	}

	static void print(int[] array){
		for(int i=0; i<array.length;i++) {
			if(array[i]==-1)
				continue;
			System.out.print(array[i]+"  ");
		}
		System.out.println();
	}
	
	static void select_sort(int[] arr){
		int min, tmp;
		
		int[] arr1=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			arr1[i]=arr[i];
		
		System.out.println("case : 선택 정렬");
		print(arr1);
				
		for(int i=0;i<arr1.length-1;i++) {
			min=i;
			for(int j=i+1;j<arr1.length;j++) {
				if(arr1[min]>arr1[j])
					min=j;
			}
			tmp=arr1[min];
			arr1[min]=arr1[i];
			arr1[i]=tmp;
			
			print(arr1);
		}
	}
	
	
	static void insert_sort(int[] arr) {
		int tmp, j;
		
		int[] arr2=new int[arr.length+1];	
		
		arr2[0]=-1;
		for(int i=1; i<arr2.length;i++)
			arr2[i]=arr[i-1];
		
		System.out.println("case : 삽입 정렬");
		print(arr2);
		
		for(int i=1;i<arr2.length-1;i++) {
			tmp=arr2[i+1];
			j=i+1;
			while(arr2[j-1]>tmp) {
				arr2[j]=arr2[j-1];
				j--;			
			}
			arr2[j]=tmp;
			print(arr2);
		}
	}
	
	
	static void shell_sort(int[] arr) {
		int tmp, j;
		
		int[] arr3=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			arr3[i]=arr[i];
		
		System.out.println("case : 쉘 정렬");		
		print(arr3);
		
		for(int interval = arr3.length; interval > 0; interval /= 2) {
            for(int i = interval; i < arr3.length; i++) {     
                tmp = arr3[i];             
                j=i-interval; 
                while(j>=0 && arr3[j]>tmp) {
                	arr3[j + interval] = arr3[j];
                	j -= interval;
                } 
                arr3[j + interval] = tmp;      
                print(arr3);
            }
        }
	}
}
