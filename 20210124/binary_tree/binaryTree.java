package binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class binaryTree {

    static node root = new node();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        Scanner scan = new Scanner(System.in);
        boolean havedata=true;

        //입력
        System.out.println("트리에 삽입할 데이터를 입력하시오.(구분자 : 스페이스)");
        String[] line = bf.readLine().split(" ");
        int len = line.length;

        //삽입
        for(int i=0; i<len;i++){
            insert_tree(Integer.parseInt(line[i]));
            print_tree(root, 1);
            System.out.println("\n\n\n");
        }
            

        //출력
        print_tree(root, 1);

        //삭제
        System.out.println("\n\n");
        while(len!=-1){
        	System.out.println("\n\n");
            System.out.println("삭제할 데이터를 입력하시오.");
            int num = scan.nextInt();

            havedata=delete_tree(num);

            if(havedata) //트리 내 데이터 존재O
                print_tree(root, 1);
            else  //트리 내 데이터 존재X
                System.out.printf("트리 내 해당 데이터가 존재하지 않습니다.\n");

            len--;
        }
    }

    static void insert_tree(int data){
        node tr = new node(data);

        if(root.getData() == -9999){
            root = tr;
            System.out.println("root insert");
            return;
        }

        node tmp = root;
        node ptmp = null;

        while(true){
            ptmp = tmp;
            if(tmp.getData()>data){ //데이터보다 기존 노드의 데이터가 큰 경우 - 기존 노드의 왼쪽 노드로 이동
                tmp=tmp.getLeft();

                if(tmp == null){
                    ptmp.setLeft(tr);
                    System.out.printf("%d left insert\n", tr.getData());
                    return;
                }
            }
            else { //데이터보다 기존 노드의 데이터가 작은 경우 - 기존 노드의 오른쪽 노드로 이동
                tmp=tmp.getRight();

                if(tmp==null){
                    ptmp.setRight(tr);
                    System.out.printf("%d right insert\n", tr.getData());
                    return;
                }
            }
        }
    }

    static boolean delete_tree(int data){  //기준 : 큰 노드 중 가장 작은 값으로 대체
        node tmp = root;
        node ptmp = root;
        boolean LChild = false;

        while(tmp.getData()!=data){ //data 탐색
            ptmp=tmp;
            if(tmp.getData()>data){
            	LChild = true;
                tmp=tmp.getLeft();
            }
            else{
            	LChild = false;
                tmp=tmp.getRight();
            }

            if(tmp == null) //트리 내 해당 데이터 없음
               return false;
        }

        if(tmp.getLeft() == null && tmp.getRight() == null){  //case1. 자식 노드가 없는 말단 노드인 경우
        	if(tmp == root)
                root=null;
            if(LChild)
            	ptmp.setLeft(null);
            else 
            	ptmp.setRight(null);
        }
        else if(tmp.getRight() == null){  //case2. 왼쪽 자식 노드만 존재하는 말단 노드인 경우 - 왼쪽 자식 노드 중 가장 큰 값으로 대체
            if(tmp == root)
                root=tmp.getLeft();
            else if(LChild)
            	ptmp.setLeft(tmp.getLeft());
            else 
            	ptmp.setRight(tmp.getLeft()); 
        }
        else if(tmp.getLeft() == null){  //case3. 오른쪽 자식 노드만 존재하는 말단 노드인 경우 - 오른쪽 자식 노드 중 가장 작은 값으로 대체
        	if(tmp == root)
                root=tmp.getRight();
            else if(LChild)
            	ptmp.setLeft(tmp.getRight());
            else 
            	ptmp.setRight(tmp.getRight()); 
        }
        else{  //case4. 왼쪽, 오른쪽 자식 노드 모두 존재하는 말단 노드인 경우 - 오른쪽 자식 노드 중 가장 작은 값으로 대체
            node mtmp=null;
            node pmtmp=null;
            node dtmp = tmp.getRight();
            
            //대체 노드 탐색
            while(dtmp != null) {
            	pmtmp = mtmp;
            	mtmp = dtmp;
            	
            	dtmp = dtmp.getLeft();
            }
            
            if(mtmp != tmp.getRight()) {
            	pmtmp.setLeft(mtmp.getRight());
            	mtmp.setRight(tmp.getRight());
            }
            
            if(tmp == root)
            	root = mtmp;
            else if(LChild)
            	ptmp.setLeft(mtmp);
            else
            	ptmp.setRight(mtmp);
            mtmp.setLeft(tmp.getLeft());
        }
        return true;
    }

    static void print_tree(node tr, int level){
        int i;

        if(tr != null){
            print_tree(tr.getRight(), level+1);
            System.out.printf("\n");

            if(tr == root)
                System.out.printf("ROOT => ");
            for(i=0; i<level && tr != root; i++)
                System.out.printf("      ");
            System.out.printf("%d", tr.getData());       	

            print_tree(tr.getLeft(), level+1);
        }
    }
}

class node{
    int data;
    node right;
    node left;

    public node(){
    	this.data = -9999;
        this.right=null;
        this.left=null;
    }

    public node(int data){
        this.data=data;
        this.right=null;
        this.left=null;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public node getLeft(){
        return left;
    }

    public void setLeft(node left){
        this.left=left;
    }

    public node getRight(){
        return right;
    }

    public void setRight(node right){
        this.right=right;
    }
}