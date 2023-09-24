package Algo_230924;

import java.util.*;
import java.io.*;

public class 연습장13 {
	public static void main(String[] args) {
		
		int arr[][]= {
				{1,2,3},
				{2,3,1}
		};
		
		Arrays.sort(arr,(a,b)->a[2]-b[2]);
		
		System.out.println(Arrays.toString(arr[0]));
	}
}