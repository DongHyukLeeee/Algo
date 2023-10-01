package Algo_230930;

public class Snippet {
			start = 5;
			finish =17;
			
			int dp [] = new int[100001];
			
			dp[start]=1;
			
			for(int i=5; i<=100000;i++) {
				if(i+1<=100000) {
					if(i%2==0) {
						dp[i]=dp[i/2]+dp[i-1]+dp[i+1];
					}
					else {
						dp[i]=dp[i-1]+dp[i+1];
					}
					
				}
				
				
			}
	//		System.out.println(bfs());
			System.out.println(cnt);
			System.out.println(dp[17]);
}

