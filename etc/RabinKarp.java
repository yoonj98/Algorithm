package RabinKarp;

import java.util.*;

public class RabinKarp {
	
    public static void matching(String txt, String pat) {
    	
		int txtlen = txt.length();
		int patlen = pat.length();
    	
    	if (txtlen < patlen) 
    		System.out.println(0);
        else {
            final int D = 31;
            final int MOD = (int)1e9 + 7;	//1*10^9 + 7 (https://hi-in.facebook.com/algoguide/posts/1117664551755294/)
            
            long head = 1;
            long patternHash = 0;
            long nowHash = 0;

            for (int i = 0; i < patlen; i++) {
                patternHash = (patternHash * D + pat.charAt(i)) % MOD;
                nowHash = (nowHash * D + txt.charAt(i)) % MOD;
                
                if (i != 0) 
                	head = (head * D) % MOD;
            }
            
            ArrayList<Integer> ans = new ArrayList<>();
            
            for (int i = 0; i <= txtlen - patlen; i++) {
                if(nowHash == patternHash) 
                	ans.add(i + 1);
                
                if(i + patlen == txtlen) 
                	break;
                
                nowHash = (D * (nowHash - txt.charAt(i) * head) + txt.charAt(i + patlen)) % MOD;
                
                if(nowHash < 0) 
                	nowHash += MOD;
            }

            for(int i = 0; i < ans.size(); i++) 
            	System.out.print(ans.get(i) + " ");
        }
    	
    	return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "rorkddhkswjseoqkrtlfgdj";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("찾을 패턴을 입력하시오.");
		String pattern = scan.nextLine();
		
        matching(txt, pattern);
	}
}
