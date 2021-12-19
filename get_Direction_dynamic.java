package get_Direction;

/*같은 package인 greedy.java에서 node class가 정의되어 있으므로 dynamic.java에서 node class 정의할 필요 없음*/

public class dynamic {

   static node[][] arr = new node[5][5];
   static int[][] direct = new int[5][5];
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      create_arr();
      
      //초기화
      for(int i=0;i<5;i++)
         for(int j=0;j<5;j++)
            direct[i][j] = -1;  
      
      for(int i=0;i<5;i++) {
         direct[0][i] = 1;
         direct[i][0] = 1;
      }
      
      //DP
      direct[0][0]=0;
      for(int i=1;i<5;i++) {
         direct[0][i] = direct[0][i-1]+arr[0][i-1].right;
         direct[i][0] = direct[i-1][0]+arr[i-1][0].left;
      }

      for(int i=1;i<5;i++) {
         for(int j=1;j<5;j++) {
            if(direct[i][j] == -1) { //아직 초기화 상태
               if(direct[i-1][j]+arr[i-1][j].left > direct[i][j-1]+arr[i][j-1].right) 
                  direct[i][j] = direct[i-1][j]+arr[i-1][j].left;
               else if(direct[i-1][j]+arr[i-1][j].left < direct[i][j-1]+arr[i][j-1].right) 
                  direct[i][j] = direct[i][j-1]+arr[i][j-1].right;
               else 
                  direct[i][j] = direct[i][j-1]+arr[i][j-1].right;
            }
         }
      }
      
      //출력
      System.out.println("Dynamic Programming 결과");
      for(int i=0;i<5;i++) {
         for(int j=0;j<5;j++) 
            System.out.print(direct[i][j]+" ");
         System.out.println();
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