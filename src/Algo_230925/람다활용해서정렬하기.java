package Algo_230925;

import java.util.*;
import java.io.*;

public class 람다활용해서정렬하기 {
	public static void main(String[] args) {
		
		int arr[][]= {
				{1,2,3},
				{2,3,1}
		};
		
		Arrays.sort(arr,(a,b)->a[2]-b[2]);
		
		System.out.println(Arrays.toString(arr[0]));
	}
}