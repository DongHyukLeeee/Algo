package Algo_230921;

import java.util.*;

public class BJ_4195_친구만들기 {
	static int p[];
	
	static int set(int x) {
		if(x!=p[x]) {
			p[x]=set(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[set(y)]=set(x);
	}
	
	public static void main(String[] args) {
		
	ArrayList<String> friendList = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	int Tcase = sc.nextInt();
	
	for(int tc=1; tc<=Tcase; tc++) {
		int N =sc.nextInt();
		String leftFriend[] = new String[N];
		String rightFriend[] = new String[N];

		for(int i=0; i<N; i++) {
			leftFriend[i]=sc.next();
			rightFriend[i]=sc.next();
			
		}
		for(int i=0; i<N; i++) {
			String l = leftFriend[i];
			String r = rightFriend[i];
			if(!friendList.contains(l)) {
				friendList.add(l);
			}
			if(!friendList.contains(r)) {
				friendList.add(r);
			}
		}
		p = new int [2*N+1];
		for(int i=1; i<=2*N;i++) {
			p[i]=i;
		}
		for(int i=0; i<N; i++) {
			String l = leftFriend[i];
			String r = rightFriend[i];
			if(p[whereIsMyfriend(l,friendList)]!=p[whereIsMyfriend(r,friendList)]) {
			union(p[whereIsMyfriend(l,friendList)],whereIsMyfriend(r,friendList));
			}
	
			for(int j=1; j<=2*N; j++) {
				set(p[j]);
			}
			int cnt[] = new int [2*N+1];
			for(int j=1; j<=2*N; j++) {
				cnt[p[j]]++;
			}
			int maxi = Integer.MIN_VALUE;
			for(int j=1; j<=2*N;j++) {
				maxi = Math.max(cnt[j],maxi);
			}
			for(int j=1; j<=2*N; j++) {
				set(p[j]);
			}
			set(p[whereIsMyfriend(l,friendList)]);
			set(p[whereIsMyfriend(r,friendList)]);
			System.out.println(maxi);
			System.out.println(Arrays.toString(p));
		}
		
			
			

			
			
	}//tcase
		
		
	}
	
	static int whereIsMyfriend(String a, ArrayList<String> b) {
		for(int i=0; i<b.size(); i++) {
			if(b.get(i).equals(a)) {
				return i+2;
			}
		}
		return -999;
		
	}
}