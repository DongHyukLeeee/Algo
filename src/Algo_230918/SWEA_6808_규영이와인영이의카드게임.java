package Algo_230918;

import java.util.*;

public class SWEA_6808_규영이와인영이의카드게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int Tcase = sc.nextInt();

		for (int tc = 1; tc <= Tcase; tc++) {

			int reference[] = new int[19];
			for (int i = 0; i < 19; i++) {
				reference[i] = i;
			}
			int in[] = new int[9];
			for (int i = 0; i < 9; i++) {
				in[i] = sc.nextInt();
			}
			int[] gyu = new int[9];
			for (int i = 0; i < 9; i++) {
				reference[in[i]] = 0;
			}
			int k = 0;
			for (int i = 0; i < 19; i++) {
				if (reference[i] != 0) {
					gyu[k] = reference[i];
					k++;
				}
			} // 여기까지가 규영이와 인영이 카드 만들어주기

			// 재귀를 위한 boolean, ArrayList 생성
			boolean check[] = new boolean[9];
			ArrayList<ArrayList<Integer>> findGyuArrays = new ArrayList<>();
			ArrayList<Integer> current = new ArrayList<>();

			findAllpermu(findGyuArrays, current, gyu, check);// 재귀로 모든 경우를 받음.
			int cnt = 0;
			for (int i = 0; i < findGyuArrays.size(); i++) {// 게임시작
				int sum_in = 0;
				int sum_gyu = 0;
				for (int j = 0; j < 9; j++) {
					if (in[j] > findGyuArrays.get(i).get(j)) {
						sum_in += in[j] + findGyuArrays.get(i).get(j);
					} else if (in[j] < findGyuArrays.get(i).get(j)) {
						sum_gyu += in[j] + findGyuArrays.get(i).get(j);
					}
				}
				if (sum_in > sum_gyu) {
					cnt++;
				}
			}
			System.out.printf("#%d %d %d", tc,  cnt, findGyuArrays.size() - cnt);
			System.out.println();
		}

	}

	public static void findAllpermu(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> current, int arr[],
			boolean check[]) {
		if (current.size() == 9) {

			list.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (check[i] == false) {
				check[i] = true;
				current.add(arr[i]);
				findAllpermu(list, current, arr, check);
				current.remove(current.size() - 1);
				check[i] = false;
			}
		}
	}

}