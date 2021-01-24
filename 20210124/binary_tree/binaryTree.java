package binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class binaryTree {

    static node root = new node();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
        Scanner scan = new Scanner(System.in);
        boolean havedata=true;

        //�Է�
        System.out.println("Ʈ���� ������ �����͸� �Է��Ͻÿ�.(������ : �����̽�)");
        String[] line = bf.readLine().split(" ");
        int len = line.length;

        //����
        for(int i=0; i<len;i++){
            insert_tree(Integer.parseInt(line[i]));
            print_tree(root, 1);
            System.out.println("\n\n\n");
        }
            

        //���
        print_tree(root, 1);

        //����
        System.out.println("\n\n");
        while(len!=-1){
        	System.out.println("\n\n");
            System.out.println("������ �����͸� �Է��Ͻÿ�.");
            int num = scan.nextInt();

            havedata=delete_tree(num);

            if(havedata) //Ʈ�� �� ������ ����O
                print_tree(root, 1);
            else  //Ʈ�� �� ������ ����X
                System.out.printf("Ʈ�� �� �ش� �����Ͱ� �������� �ʽ��ϴ�.\n");

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
            if(tmp.getData()>data){ //�����ͺ��� ���� ����� �����Ͱ� ū ��� - ���� ����� ���� ���� �̵�
                tmp=tmp.getLeft();

                if(tmp == null){
                    ptmp.setLeft(tr);
                    System.out.printf("%d left insert\n", tr.getData());
                    return;
                }
            }
            else { //�����ͺ��� ���� ����� �����Ͱ� ���� ��� - ���� ����� ������ ���� �̵�
                tmp=tmp.getRight();

                if(tmp==null){
                    ptmp.setRight(tr);
                    System.out.printf("%d right insert\n", tr.getData());
                    return;
                }
            }
        }
    }

    static boolean delete_tree(int data){  //���� : ū ��� �� ���� ���� ������ ��ü
        node tmp = root;
        node ptmp = root;
        boolean LChild = false;

        while(tmp.getData()!=data){ //data Ž��
            ptmp=tmp;
            if(tmp.getData()>data){
            	LChild = true;
                tmp=tmp.getLeft();
            }
            else{
            	LChild = false;
                tmp=tmp.getRight();
            }

            if(tmp == null) //Ʈ�� �� �ش� ������ ����
               return false;
        }

        if(tmp.getLeft() == null && tmp.getRight() == null){  //case1. �ڽ� ��尡 ���� ���� ����� ���
        	if(tmp == root)
                root=null;
            if(LChild)
            	ptmp.setLeft(null);
            else 
            	ptmp.setRight(null);
        }
        else if(tmp.getRight() == null){  //case2. ���� �ڽ� ��常 �����ϴ� ���� ����� ��� - ���� �ڽ� ��� �� ���� ū ������ ��ü
            if(tmp == root)
                root=tmp.getLeft();
            else if(LChild)
            	ptmp.setLeft(tmp.getLeft());
            else 
            	ptmp.setRight(tmp.getLeft()); 
        }
        else if(tmp.getLeft() == null){  //case3. ������ �ڽ� ��常 �����ϴ� ���� ����� ��� - ������ �ڽ� ��� �� ���� ���� ������ ��ü
        	if(tmp == root)
                root=tmp.getRight();
            else if(LChild)
            	ptmp.setLeft(tmp.getRight());
            else 
            	ptmp.setRight(tmp.getRight()); 
        }
        else{  //case4. ����, ������ �ڽ� ��� ��� �����ϴ� ���� ����� ��� - ������ �ڽ� ��� �� ���� ���� ������ ��ü
            node mtmp=null;
            node pmtmp=null;
            node dtmp = tmp.getRight();
            
            //��ü ��� Ž��
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