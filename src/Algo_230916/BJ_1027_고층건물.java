package Algo_230916;

import java.util.*;

public class BJ_1027_고층건물 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int arr[] = new int [N];
		for(int i=0; i<N ;i++) {
			arr[i] = sc.nextInt();
		}
		int res=0;
		for (int i = 0; i <N; i++) {


				int cnt =0;
				double currentSlope =  +999999999.5;
				for(int k=i-1; k>=0; k--) {
					double temp = (double) (arr[i] - arr[k]) / (i - k);
					if(temp < currentSlope){
						currentSlope = temp;
						cnt++;
					}
				}
				currentSlope = -999999999.5;
				for(int k=i+1; k<N; k++) {
					double temp = (double) (arr[i] - arr[k]) / (i - k);
					if(temp > currentSlope){
						currentSlope = temp;
						cnt++;
					}
				}
				res = Math.max(cnt,res);

		}

		System.out.println(res);
	}
	
}