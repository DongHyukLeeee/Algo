package Algo_230920;

import java.util.*;

public class SW_하나로 {
	static int[] p;
	
	static int findset(int x) {
		if(x!=p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	static void union(int x, int y) {
		p[findset(y)]=findset(x);
	}
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);	
	int Tcase = sc.nextInt();
	for(int tc=1; tc<=Tcase; tc++) {
	int N = sc.nextInt();
	p = new int[N];
	for(int i=0; i<N ;i++) {
		p[i]=i;
	}
	int arr[][] =new int [N][2];
	for(int i=0; i<N ;i++) {
		arr[i][0]=sc.nextInt();//x좌표
	}
	for(int i=0; i<N ;i++) {
		arr[i][1]=sc.nextInt();//x좌표
	}
	double multi = sc.nextDouble();
	int all[][] = new int [N*(N-1)][3];
	int k=0; 
	for(int i=0; i<N; i++) {
		for(int j=0;j<N; j++) {
			if(i!=j) {
			int dx = arr[i][0]-arr[j][0];
			int dy = arr[i][1]-arr[j][1];
			all[k][0]=i;
			all[k][1]=j;
			all[k][2]=dx*dx+dy*dy;
			k++;
			}
		}
	}
	Arrays.sort(all,new Comparator<int []>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1[2], o2[2]);
		}
	});
	

	int sum=0;
	int cnt=0;
	for(int i=0; i<all.length; i++) {
		int x = all[i][0];
		int y = all[i][1];
		if(findset(x)!=findset(y)) {
			union(x,y);
			sum+=all[i][2];
			cnt++;
		}
		if(cnt==N-1) {
			break;
		}
	}
	
	System.out.println( (int) (sum*multi));


	}
		
	}
	



}