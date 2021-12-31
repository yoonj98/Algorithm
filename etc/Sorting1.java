package sorting1;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorting1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		
		//�Է�
		System.out.println("������ �����͸� �Է��Ͻÿ�.(������ : �����̽�)");
		String[] line = bf.readLine().split(" ");
		int len = line.length;
		
		int[] arr=new int[len];

		for(int i=0; i<len;i++)
			arr[i] = Integer.parseInt(line[i]);
		
		//������
		int[] arr1=new int[arr.length];
		for(int k=0;k<arr.length;k++)
			arr1[k]=arr[k];
		
		System.out.println("case : �� ����");
		print(arr1);
		
		quick_sort(arr1, 0, len-1);
		System.out.println();
		
		//�պ�����
		int[] arr2=new int[arr.length];
		for(int k=0;k<arr.length;k++)
			arr2[k]=arr[k];
		
		System.out.println("case : �պ� ����");
		print(arr2);
		
		merge_sort(arr2, 0, len-1);
		print(arr2);

	}
	
	static void print(int[] array){
		for(int i=0; i<array.length;i++) 
			System.out.print(array[i]+"  ");
		System.out.println();
	}
	
	static void quick_sort(int[] arr, int start, int end){
		int pivot=start;
		int i = pivot+1;
		int j=end;
		int tmp;
		
		if(start>=end)
			return;

		while(i <= j){ //������������ �ݺ�
			while(i <= end && arr[i] >= arr[pivot])
				i++;
			while(j > start && arr[j] <= arr[pivot])
				j--;

			if(i > j){ // ������ ��
				tmp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = tmp;
			}
			else{	
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			print(arr);
		}

		// ���� ���
		quick_sort(arr, start, j-1);
		quick_sort(arr, j+1, end);		
	}
	
	static void merge(int[] arr, int start, int middle, int end) {
		int[] temp = new int[end-start+1];
		int left = start;
		int right = middle+1;
		int i=0;
		
		do {
			if(arr[left]<arr[right]) 
				temp[i++] = arr[right++];
			else 
				temp[i++] = arr[left++];
		}while(left<=middle && right<=end);

		while(left<=middle) 
			temp[i++] = arr[left++];
		while(right<=end) 
			temp[i++] = arr[right++];

		for(i=0; i<temp.length; i++) 
			arr[start+i]=temp[i];
		print(arr);
	}
	
	static void merge_sort(int[] arr, int start, int end){
		if(start==end) 
			return;
		int middle = (start+end)/2;

		merge_sort(arr, start, middle);
		merge_sort(arr, middle+1, end);
		merge(arr, start, middle, end);
	}


}
