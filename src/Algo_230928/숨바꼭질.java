
import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.io.*;
import java.text.BreakIterator;

public class 숨바꼭질 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(input2);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];

		dp[0] = arr[0];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 1], dp[i - 1]);
		}

		System.out.println(Arrays.toString(dp));

	}

	static String input1 = "" + "6 2 -1 3 1 2 4 -1";
	static String input2 = "" + "7 1 -1 3 -4 4 5 -1 2";
}