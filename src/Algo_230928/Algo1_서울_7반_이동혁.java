

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Algo1_서울_7반_이동혁 {

	static int N;
	static int arr[];

	public static void main(String[] args) {
		
		//추가점수 받기위해서 추가조건도 구현하였습니다.
		Scanner sc = new Scanner(System.in);
		
		int Tcase = sc.nextInt();

		for (int tc = 1; tc <= Tcase; tc++) {
			//N 과 K를 입력받음, N은 dfs()함수에서 쓸것이기 떄문에, 전역으로 
			N = sc.nextInt();
			int K = sc.nextInt();
			
			//아래의 ArrayList는 dfs함수에서 사용하기 위해서 만듬. 
			ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
			ArrayList<Integer> current = new ArrayList<>();
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			//sorting해주어야 함.
			Arrays.sort(arr);
			
			//dfs함수가 끝나면 arrList에 모든 순열이 저장될 것임>,
			boolean used[] = new boolean[N];
			
			dfs(arrList, current,used);
			

			
			
			//문제의 조건에 따라 size()보다 K가 크다면 -1이 출력
		
			if (arrList.size() < K) {
				System.out.println("#" + tc + " -1");
				// 그렇지 않으면 원래 값이 나오도록 함.
			} else {
				System.out.printf("#" + tc + " ");
				for (int a : arrList.get(K - 1)) {
					System.out.printf("%d ", a);
				}
				System.out.println();

			}

		}
		sc.close();

	}

	static void dfs(ArrayList<ArrayList<Integer>> aList, ArrayList<Integer> cur, boolean used[]) {
		if (cur.size() == N) {
			//중복된 원소는 들어가지 않게합니다.
			//cur과 기존에 있는 aList의 원소를 비교하고, aList가 이미 가지고 있는 원소라면 넣지 않습니다.
			//이 작업을 해주지 않으면 1 2 2 2 2 와 같은 경우에 -1이 나와야하는데 ,나오질 않습니다.
			if(!aList.contains(cur))
			aList.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = 0; i < N; i++) {
			
			//중복을 피해야하므로 아래와 같은 if가 필요
			//boolean으로 방문체크해줍니다.
			
			if (!used[i]) {
				used[i]=true;
			//중복되지 않는다면 넣어준다. 
				cur.add(arr[i]);
				
				//재귀
				dfs(aList, cur,used);
				//백트래킹
				used[i]=false;
				cur.remove(cur.size() - 1);

			}

		}

	}

}
