package Algo_230916;

import java.util.*;

public class BJ_14889_스타트와_링크 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int arr[][] = new int [N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int mini = 10000;
		
		
		for(int msk = 0; msk < 1<<N; msk++) {
			if(Integer.bitCount(msk)==N/2) {
			ArrayList<Integer> team1 = new ArrayList();
			ArrayList<Integer> team2 = new ArrayList();
			int team1Score = 0;
			int team2Score = 0;
			for(int i=0; i<N; i++)

			if((msk&(1<<i))>0) 
			{
				team1.add(i);
			}
			else
			{
				team2.add(i);
			}
			for(int i=0; i<team1.size(); i++) 
			{
				for(int j=0; j<team1.size();j++) 
				{
					team1Score +=arr[team1.get(i)][team1.get(j)];
				}
			}
			for(int i=0; i<team2.size(); i++) 
			{
				for(int j=0; j<team2.size();j++) 
				{
					team2Score +=arr[team2.get(i)][team2.get(j)];
				}
			}
			
			mini = Math.min(Math.abs(team1Score-team2Score),mini);
			}//if
			
		}//msk
	
		
	System.out.println(mini);	
	}
	
}