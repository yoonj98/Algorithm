import java.util.Scanner;

public class decomepose_sum {
    static int min = 999999999;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        String len = Integer.toString(N);
        int lenn =  Integer.parseInt(len)-1;
        int num = N-9*lenn;

        min = cal(num, N);

        if(min != 999999999)
            System.out.println(min);
        else
            System.out.println(0);
    }

    static public int cal(int num, int N){
        int sum;
        while(num<=N){
            sum = num;
            String ss = Integer.toString(num);
            for (int i = 0; i < ss.length(); i++)
                sum += ss.charAt(i)-'0';
            if(sum == N)
                min = (sum < min) ? num : min;
            num++;
        }
        return min;
    }
}
