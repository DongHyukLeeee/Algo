package Algo_230916;

import java.util.*;


public class BJ_14888_연산자끼워넣기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int number []  = new int [N];
		for(int i=0; i<N; i++) {
			number[i] = sc.nextInt();
		}
		int arr[] = new int [4];
		for(int i=0; i<4; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Character> chas = new ArrayList<Character>();
		ArrayList<ArrayList<Character>> All = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> current = new ArrayList<Character>();

			for(int j=0; j<arr[0]; j++) {
				chas.add('+');
			}
			for(int j=0; j<arr[1]; j++) {
				chas.add('-');
			}
			for(int j=0; j<arr[2]; j++) {
				chas.add('*');
			}
			for(int j=0; j<arr[3]; j++) {
				chas.add('/');
			}
		
		
		boolean[] used = new boolean[N-1];
		allPermu(chas, All,current, N-1, used);
		
		int mini = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;
		for(int i=0; i<All.size(); i++) {
			int temp = number[0];
 			for(int j=0; j<N-1; j++) {
				temp=basicMath(All.get(i).get(j),temp,number[j+1]);
			}
			mini = Math.min(mini,temp);
			maxi = Math.max(maxi,temp);
		}
		
		System.out.println(maxi);
		System.out.println(mini);
			
		}
	

	public static void allPermu
	
	(
	ArrayList<Character> chas, ArrayList<ArrayList<Character>> All,	ArrayList<Character> current, int A, boolean used[]
	) 
	{
		if (current.size() == A) {
			ArrayList<Character> copy = new ArrayList<Character>(current);
			All.add(copy);
			return;

		}
		for (int i = 0; i < chas.size(); i++) {
			if (used[i] == true)
				continue;

			used[i] = true;
			current.add(chas.get(i));
			allPermu(chas, All, current, A, used);
			used[i] = false;
			current.remove(current.size() - 1);
		}

	}

	public static int basicMath(char a, int x, int y) {

		switch (a) {

		case '+':
			return x + y;

		case '*':
			return x * y;
		case '/':
			return x / y;

		case '-':
			return x - y;

		}
		return -9999;
	}
}