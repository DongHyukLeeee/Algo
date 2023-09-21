package Algo_230921;

import java.util.*;

public class BJ_4195_친구만들기 {
	static int p[];

	static int set(int x) {
		if (x != p[x]) {
			p[x] = set(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		int px = set(x);
		int py = set(y);
			if(px != py) {
				p[py] = px;	
			}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> friendList = new ArrayList<String>();

		int Tcase = sc.nextInt();

		for (int tc = 1; tc <= Tcase; tc++) {
			int N = sc.nextInt();
			String leftFriend[] = new String[N];
			String rightFriend[] = new String[N];

			for (int i = 0; i < N; i++) {
				leftFriend[i] = sc.next();
				rightFriend[i] = sc.next();

			}
			for (int i = 0; i < N; i++) {
				String l = leftFriend[i];
				String r = rightFriend[i];
				if (!friendList.contains(l)) {
					friendList.add(l);
				}
				if (!friendList.contains(r)) {
					friendList.add(r);
				}
			}
			p = new int[2 * N + 1];
			for (int i = 1; i <= 2 * N; i++) {
				p[i] = i;
			}

			HashMap<String,Integer> hMap = new HashMap<>();
			//		key		value
			int index = 0;
			for (int i = 0; i <  N; i++) {
				String le = leftFriend[i];
				String ri = rightFriend[i];
				
				if(!hMap.containsKey(le)) {
					hMap.put(le, index++);
				}
				if(!hMap.containsKey(ri)) {
					hMap.put(ri, index++);
				}
			}
			
			for (int i = 0; i <  N; i++) {
				String le = leftFriend[i];
				String ri = rightFriend[i];
				int x = hMap.get(le);
				int y = hMap.get(ri);
				
				if(x!=y) {
					union(x,y);
				}


				int cnt[] = new int [2*N+1];
				int maxi = 0;
				for(int j=0; j<=2*N ; j++) {
					cnt[p[j]]++;
				}
				for(int j=0; j<=2*N ; j++) {
					maxi = Math.max(cnt[j], maxi);
				}
				System.out.println(maxi);
				
			}
			
			

		} // tcase

	}


}