package Algo_230919;

import java.util.*;

public class SWEA_1952_수영장 {
	public static void main(String[] args) {
		int[][] arr = { 

				{ 9, 8, 9, 8 },
				{ 4, 6, 9, 4 }, 
				{ 8, 7, 7, 8 },
				{ 4, 5, 3, 5 } 
				};
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
		int maxi = Integer.MIN_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			if(isRectagle(list.get(i))) {
				maxi = Math.max(countDessert(arr,list.get(i)),maxi);
			}
			
		}
		
		System.out.println(maxi);

	}
	
	public static boolean isRectagle(ArrayList<int[]> intList) {
			if(
					Math.abs(intList.get(0)[0] - intList.get(1)[0]) == Math.abs(intList.get(0)[1] - intList.get(1)[1]) &&
					Math.abs(intList.get(0)[0] - intList.get(3)[0]) == Math.abs(intList.get(0)[1] - intList.get(3)[1]) &&
					Math.abs(intList.get(1)[0] - intList.get(2)[0]) == Math.abs(intList.get(1)[1] - intList.get(2)[1]) &&
					Math.abs(intList.get(2)[0] - intList.get(3)[0]) == Math.abs(intList.get(2)[1] - intList.get(3)[1])
			) {
				return true;
			}

		return false;
	}
	
	
	public static int countDessert(int arr[][] , ArrayList<int[]> intList) {
		int left=Integer.MAX_VALUE, right = Integer.MIN_VALUE, 
		bottom = Integer.MIN_VALUE, top =  Integer.MAX_VALUE;
		int countingDesert [] = new int [101];
		for(int i=0; i<4; i++) {
			top = Math.min(intList.get(i)[0],top);
			bottom = Math.max(intList.get(i)[0],bottom);
			right = Math.max(intList.get(i)[1],right);
			left = Math.min(intList.get(i)[1],left);
		}
		int i_index = intList.get(0)[0];
		for(int j=intList.get(0)[1]; j>=left; j--) {
			countingDesert[arr[i_index][j]]++;
			i_index++;
		}
		i_index=intList.get(0)[0];
		for(int j=intList.get(0)[1]; j<=right; j++) {
			countingDesert[arr[i_index][j]]++;
			i_index++;
		}
		i_index=intList.get(3)[0];
		for(int j=intList.get(3)[1]; j>left; j--) {
			countingDesert[arr[i_index][j]]++;
			i_index--;
		}
		i_index=intList.get(3)[0];
		for(int j=intList.get(3)[1]; j<right; j++) {
			countingDesert[arr[i_index][j]]++;
			i_index--;
		}
		countingDesert[arr[intList.get(0)[0]][intList.get(0)[1]]]--;
		countingDesert[arr[intList.get(3)[0]][intList.get(3)[1]]]--;
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(countingDesert[i]>1) {
				return -1;
			}
			sum+=countingDesert[i];
		}
		return sum;
		
	}
	

}
