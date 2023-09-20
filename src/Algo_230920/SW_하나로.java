package Algo_230920;

import java.util.*;

public class SW_하나로 {
	static int[] p;

	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}/////// findset

	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}///////// union

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tcase = sc.nextInt();
		for (int tc = 1; tc <= Tcase; tc++) {
			int N = sc.nextInt();
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			double arr[][] = new double[N][2]; // X, Y 좌표를 long으로 변경
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextDouble(); // x좌표를 double으로 변경
			}
			for (int i = 0; i < N; i++) {
				arr[i][1] = sc.nextDouble(); // y좌표를 double으로 변경
			}
			double multi_currency = sc.nextDouble();
			double all[][] = new double[N * (N - 1)][3];
			int k = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						double dx = arr[i][0] - arr[j][0]; // double으로 변경
						double dy = arr[i][1] - arr[j][1]; // double으로 변경
						all[k][0] = i;
						all[k][1] = j;
						all[k][2] = dx * dx + dy * dy; // double으로 변경
						k++;
					}
				}
			}
			
			Arrays.sort(all, new Comparator<double[]>() { // 배열 데이터 형식을 double으로 변경
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});

			double sum = 0; // 결과 값을 double으로 변경
			int cnt = 0;
			for (int i = 0; i < all.length; i++) {
				int x = (int) all[i][0]; // 결과를 출력할 때는 다시 int로 형변환
				int y = (int) all[i][1]; // 결과를 출력할 때는 다시 int로 형변환
				if (findset(x) != findset(y)) {
					union(x, y);
					sum += all[i][2];
					cnt++;
				}
				if (cnt == N - 1) {
					break;
				}
			}
			long answer = Math.round(sum * multi_currency);//반올림관련 tcase 에러 해결

			System.out.println("#" + tc + " " + answer); 

		}

	}
}