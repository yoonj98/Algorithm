package RedBlack_tree;

import java.util.*;

public class RedBlack_tree {

	static node root = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� : I  |  ���� : D  |  ��� : P  |  ���� : Q");
		Scanner scan = new Scanner(System.in);
		String menu = scan.nextLine();
		int num;
		
		while(!menu.toUpperCase().equals("Q")) {
			if(menu.toUpperCase().equals("I")) {
				System.out.println("������ ���Ҹ� �Է��ϼ���.");
				num = Integer.parseInt(scan.nextLine());
				insert(num);
			}
			else if(menu.toUpperCase().equals("D")) {
				System.out.println("������ ���Ҹ� �Է��ϼ���.");
				num = Integer.parseInt(scan.nextLine());
				delete(num);
			}
			else if(menu.toUpperCase().equals("P")) {
				print(root, 1);	
				System.out.println();
			}
			
			System.out.println("\n���� : I  |  ���� : D  |  ��� : P  |  ���� : Q");
			menu = scan.nextLine();	
		}
	}
	
	static void insert(int data) {
		/* insert node = red
		 * 1. parent node = red & uncle node = red >> grand node = red(grand node = root >> black) & parent + uncle node = black
		 * 2. parent node = red & uncle node = black || non uncle node >> rotation
		 * 		rotation : insert node, parent node, grand node�� ������ ������ �������� ��, ��� ��带 �θ�� �ﵵ�� ȸ�� (��� ��� = black & ������ ��� = red)
		 * 		2-1. insert node = parent's right node >> rotate Left
		 * 		2-2. insert node = parent's left node >> rotate right
		 * */
		
		 node rb = new node(data);
		 
		 if(root == null){
	            root = rb;
	            root.setColor("b");
	            System.out.println("root insert");
	            return;
	        }
	     else {
	    	 node tmp = root;
		     node ptmp = null;	//parent node

		     while(true){
		    	 ptmp = tmp;
		         if(tmp.getData()>data){ //�����ͺ��� ���� ����� �����Ͱ� ū ��� - ���� ����� ���� ���� �̵�
		        	 tmp=tmp.getLeft();

		             if(tmp == null){
		            	 ptmp.setLeft(rb);
		            	 rb.setParent(ptmp);
		                 break;
		             }
		         }
		         else { //�����ͺ��� ���� ����� �����Ͱ� ���� ��� - ���� ����� ������ ���� �̵�
		        	 tmp=tmp.getRight();

		             if(tmp==null){
		            	 ptmp.setRight(rb);
		            	 rb.setParent(ptmp);
		                 break;
		             }
		          }
		     }
		     insert_fix(rb);
	     } 
	}
	
	static void insert_fix(node rb) {
		while(rb.getParent() != null && rb.getParent().getColor().equals("r")) {
			node uncle = null;
			
			if(rb.getParent() == rb.getParent().getParent().getLeft()) {	//���Ե� ����� �θ� ��尡 grand ����� ���� �ڽ��� ��
				uncle = rb.getParent().getParent().getRight();	
				
				if(uncle != null && uncle.getColor().equals("r")){	//grand node = red(grand node = root >> black) & parent + uncle node = black
					uncle.setColor("b");
					rb.getParent().setColor("b");
					rb.getParent().getParent().setColor("r");
					
					rb = rb.getParent().getParent();
					continue;
				}
				
				if(rb == rb.getParent().getRight()) {
					rb = rb.getParent();
					rotateL(rb);
				}
				
				rb.getParent().setColor("b");
				rb.getParent().getParent().setColor("r");
				
				rotateR(rb.getParent().getParent());
				break;
			}
			else {
				uncle = rb.getParent().getParent().getLeft();
				
				if(uncle != null && uncle.getColor().equals("r")){
					uncle.setColor("b");
					rb.getParent().setColor("b");
					rb.getParent().getParent().setColor("r");
					
					rb = rb.getParent().getParent();
					continue;
				}
				
				if(rb == rb.getParent().getLeft()) {
					rb = rb.getParent();
					rotateR(rb);
				}
				
				rb.getParent().setColor("b");
				rb.getParent().getParent().setColor("r");
				
				rotateL(rb.getParent().getParent());
				break;
			}
		}
		root.setColor("b");		
	}
	
	static void rotateL(node rb) {
		if (rb.parent == null) {	
			node right = root.right;
			root.right = root.right.left;
			right.left = new node();
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = null;
			root = right;
		}
		else {
			if (rb == rb.parent.left)
				rb.parent.left = rb.right;
			else
				rb.parent.right = rb.right;
			
			rb.right.parent = rb.parent;
			rb.parent = rb.right;
			
			if (rb.right.left != null)
				rb.right.left.parent = rb;
			
			rb.right = rb.right.left;
			rb.parent.left = rb;
		}
	}
	
	static void rotateR(node rb) {
		if (rb.parent == null) {
			node left = root.left;
			root.left = root.left.right;
			left.right = new node();
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = null;
			root = left;
		}
		else {
			if (rb == rb.parent.left)
				rb.parent.left = rb.left;
			else
				rb.parent.right = rb.left;
			
			rb.left.parent = rb.parent;
			rb.parent = rb.left;
			
			if (rb.left.right != null)
				rb.left.right.parent = rb;
			
			rb.left = rb.left.right;
			rb.parent.right = rb;
		}
	}
	
	static void delete(int data) {
		/* 1. delete node = red >> ���� ����
		 * 2. delete node = black
		 * 	2-1. ���� �� ��ü�Ǵ� node >> black���� ��ȯ (�ʼ�) - ���������� ���� �߻� O
		 * 		���������� = ������ ��� ��带 �� ������� ����
		 * 		**���������尡 �θ� ����� ���� �ڽ��̶�� ���� (��Ī�� ��쵵 ��� �ʿ�)**
		 * 			1. ���� ��� = red >> ���� ��� = black + �θ� ��� = red + �θ� ��� ���� rotation (left)
		 * 			2. ���� ��� = black & ���� ����� ���� �ڽ� ��� black >> ���� ��� = red + ������������ black 1���� parent���� ���� (parent = red >> ��Ȳ ���� || parent = black >> �ٽ� ���������� - root ���� �� ����)
		 * 			3. ���� ��� = black & ���� ����� ���� �ڽ� = red & ���� ����� ������ �ڽ� = black >> ���� ��� = red & ���� ����� ���� �ڽ� = red & ���� ��� ���� rotation (right)
		 *          4. ���� ��� = black & ���� ����� ������ �ڽ� = red >> parent�� ���� ���� ��忡�� ���� + �θ� ���� ���� ����� ������ �ڽ� >> black + �θ� ��� ���� rotation (left)
		 * */
	}
	
	static void delete_fix(node rb) {
		node sibling = null;
		
		while(rb != root && rb.getColor().equals("b")) {
			if(rb == rb.getParent().getLeft()) {
				sibling = rb.getParent().getRight();
				
				if(sibling.getColor().equals("r")) {
					sibling.setColor("b");
					rb.getParent().setColor("r");
					rotateL(rb.getParent());
					
					sibling = rb.getParent().getRight();
				}
				
				if(sibling.getLeft().getColor().equals("b") && sibling.getRight().getColor().equals("b")) {
					sibling.setColor("r");
					rb = rb.getParent();
				}
				else if(sibling.getLeft().getColor().equals("r") && sibling.getRight().getColor().equals("b")) {
					sibling.setColor("r");
					sibling.getLeft().setColor("b");
					rotateR(sibling);
					
					sibling = rb.getParent().getRight();
				}
				
				if(sibling.getRight().getColor().equals("r")) {
					sibling.setColor(rb.getParent().getColor());
					sibling.getRight().setColor("b");
					rb.getParent().setColor("b");
					rotateL(rb.getParent());
					
					rb = root;
				}
			}
			else {
				sibling = rb.getParent().getLeft();
				
				if(sibling.getColor().equals("r")) {
					sibling.setColor("b");
					rb.getParent().setColor("r");
					rotateR(rb.getParent());
					
					sibling = rb.getParent().getLeft();
				}
				
				if(sibling.getRight().getColor().equals("b") && sibling.getLeft().getColor().equals("b")) {
					sibling.setColor("r");
					rb = rb.getParent();
				}
				else if(sibling.getRight().getColor().equals("r") && sibling.getLeft().getColor().equals("b")) {
					sibling.setColor("r");
					sibling.getRight().setColor("b");
					rotateL(sibling);
					
					sibling = rb.getParent().getLeft();
				}
				
				if(sibling.getLeft().getColor().equals("r")) {
					sibling.setColor(rb.getParent().getColor());
					sibling.getLeft().setColor("b");
					rb.getParent().setColor("b");
					rotateR(rb.getParent());
					
					rb = root;
				}
			}
		}
		
	}

	static void print(node tr, int level){
	    int i;

	    if(tr != null){
	    	print(tr.getRight(), level+1);
	        System.out.printf("\n");

	        if(tr == root)
	            System.out.printf("ROOT => ");
	        for(i=0; i<level && tr != root; i++)
	            System.out.printf("      ");
	        System.out.printf("%d[%s]", tr.getData(), tr.getColor());

	        print(tr.getLeft(), level+1);
	    }
	}
	
}

class node{
    int data;
    String color;
    
    node right;
    node left;
    node parent;

    public node(){
    	this.data = -9999;
    	this.color = "b";
        this.right=null;
        this.left=null;
        this.parent = null;
    }

    public node(int data){
        this.data=data;
    	this.color = "r";
        this.right=null;
        this.left=null;
        this.parent = null;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }
    
    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
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
    
    public node getParent(){
        return parent;
    }

    public void setParent(node parent){
        this.parent=parent;
    }
}