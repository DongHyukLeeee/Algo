package Algo_230920;

import java.util.*;

public class BJ_1759_암호만들기 {
	static int M, N;

	public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        
        String a = "";
        

        
        for(int i=0; i<N; i++) {
        	a+=sc.next();
        }
        char[] ch =  a.toCharArray();
        
        Arrays.sort(ch);
        ArrayList<String> list = new ArrayList<>();
        
        for(int msk =0; msk <1<<N ;msk++) {
        	if(Integer.bitCount(msk)==M) {
        	char temp[] =new char[M];
        	String tmp = "";
        	int k=0;
        	for(int i=0; i<N; i++) {
        		if((msk&1<<i)>0) {
        		temp[k]=ch[i];
        		k++;
        		}
        	}
        	Arrays.sort(temp);
        	for(int i=0; i<M;i++) {
        		tmp+=temp[i];
        	}
        	if(check(tmp)) {
        	list.add(tmp);
        	}
        }
        }
        
        Collections.sort(list);
        
        for(String x : list) {
        	System.out.println(x);
        }
    }

	static boolean check(String a) {
		int jaum =0;
		int moum =0;
		for(int i=0; i<a.length(); i++) {
			char temp = a.charAt(i);
			if(temp=='a'||
			   temp=='e'||
			   temp=='i'||
			   temp=='o'||
			   temp=='u'){
				moum++;
			}
			else {
				jaum++;;
			}
			
		}
		if(jaum>=2&&moum>=1) {
			return true;
		}
		else return false;
			
	}
	
}
