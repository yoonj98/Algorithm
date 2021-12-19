package get_Direction;

public class greedy {

	static node[][] arr = new node[5][5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		int tmp=0;
		
		create_arr();
		
		System.out.println(tmp);
		while(true) {
			if(arr[i][j].right>arr[i][j].left) {
				tmp+=arr[i][j].right;
				j++;
				System.out.println(tmp);
			}
			else if(arr[i][j].right<arr[i][j].left) {
				tmp+=arr[i][j].left;
				i++;
				System.out.println(tmp);
			}
			else
				break;
		}	
	}
	
	static void create_arr() {
		arr[0][0] = new node(3, 1);
		arr[0][1] = new node(2, 0);
		arr[0][2] = new node(4, 2);
		arr[0][3] = new node(0, 4);
		arr[0][4] = new node(-1, 3);

		arr[1][0] = new node(3, 4);
		arr[1][1] = new node(2, 6);
		arr[1][2] = new node(4, 5);
		arr[1][3] = new node(1, 2);
		arr[1][4] = new node(-1, 1);
		
		arr[2][0] = new node(0, 4);
		arr[2][1] = new node(7, 4);
		arr[2][2] = new node(3, 5);
		arr[2][3] = new node(4, 2);
		arr[2][4] = new node(-1, 1);
		
		arr[3][0] = new node(3, 5);
		arr[3][1] = new node(3, 6);
		arr[3][2] = new node(0, 8);
		arr[3][3] = new node(2, 5);
		arr[3][4] = new node(-1, 3);
		
		arr[4][0] = new node(1, -1);
		arr[4][1] = new node(3, -1);
		arr[4][2] = new node(2, -1);
		arr[4][3] = new node(2, -1);
		arr[4][4] = new node(-1, -1);	
	}
}

class node{
    int right;
    int left;

    public node(int right, int left) {
        this.right = right;
        this.left = left;
    }
}
