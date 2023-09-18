package Algo_230916;

import java.util.*;

import javax.annotation.Generated;

public class BJ_14888_연산자끼워넣기_Copy {

	public static void main(String[] args) {

		ArrayList<Character> chas = new ArrayList<Character>();
		ArrayList<ArrayList<Character>> All = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> current = new ArrayList<Character>();
		chas.add('+');
		chas.add('+');

		chas.add('-');
		chas.add('*');
		chas.add('/');
		boolean[] used = new boolean[5];
		generatePermute(chas, 5, current, All, used);

		System.out.println(All);

	}

	public static void generatePermute(ArrayList<Character> chas, int N, ArrayList<Character> current,
			ArrayList<ArrayList<Character>> All, boolean[] used) {

		if (current.size() == N) {
			All.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (used[i])
				continue;
			used[i]=true;
			current.add(chas.get(i));
			generatePermute(chas, N, current, All, used);
			current.remove(current.size() - 1);
			used[i]=false;

		}

	}
}