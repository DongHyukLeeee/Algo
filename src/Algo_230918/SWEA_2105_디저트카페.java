package Algo_230918;

import java.util.*;

public class SWEA_2105_디저트카페 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int N = arr.length;
		ArrayList<Integer> index_i = new ArrayList<Integer>();
		ArrayList<Integer> index_j = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				index_i.add(i);
				index_j.add(j);
			}
		}
		ArrayList<ArrayList<int []>> list = new ArrayList<>();

		for (int msk = 0; msk < 1 << index_i.size(); msk++) {
			if (Integer.bitCount(msk) == 4) {
			ArrayList<int []> tmp = new ArrayList<>();
				for (int i = 0; i < index_i.size(); i++) {
					if ((msk & 1 << i) > 0) {
						int temp[] = new int [2];
						temp[0]=index_i.get(i);
						temp[1]=index_j.get(i);
						tmp.add(temp);
					}
				}
				list.add(tmp);
			}
		}

		System.out.println(index_i);
		System.out.println(index_j);
		for(int i=0; i<list.size(); i++) {
		System.out.printf("%d %d%d %d%d %d" ,list.get(i).get(0)[0],list.get(i).get(0)[1],list.get(i).get(1)[0],list.get(i).get(1)[1],list.get(i).get(2)[1],list.get(i).get(2)[1]);
		}
	}

}
