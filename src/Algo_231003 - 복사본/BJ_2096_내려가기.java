package Algo_231003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

public class BJ_2096_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	Scanner scanner = new Scanner(System.in);
	int N  = scanner.nextInt();
	int[] temp = new int[3];
	for(int i=0; i<3; i++) {
		temp[i]=scanner.nextInt();
	}
	int[] dpH = Arrays.copyOf(temp, N);
	int[] dpL = Arrays.copyOf(temp, N);
	
	for(int i=1; i<N; i++) {
		for(int j=0; j<3; j++) {
		temp[j]=scanner.nextInt();
		}
		dpH[0] = Math.max(temp[0]+dpH[0], temp[1]+dpH[0]);
		dpH[1] = Math.max(temp[1]+dpH[1], Math.max(temp[0]+dpH[1], temp[2]+dpH[1]));
		dpH[2] = Math.max(temp[1]+dpH[2], temp[2]+dpH[2]);
		
		dpL[0] = Math.min(temp[0]+dpL[0], temp[1]+dpL[0]);
		dpL[1] = Math.min(temp[1]+dpL[1], Math.min(temp[0]+dpL[1], temp[2]+dpL[1]));
		dpL[2] = Math.min(temp[1]+dpL[2], temp[2]+dpL[2]);
	
		
	}
	System.out.printf("%d %d", Math.max(dpH[0],Math.max(dpH[1], dpH[2])),  Math.min(dpL[0],Math.min(dpL[1], dpL[2]))    );
}
	
	static String input1 = "3\r\n"
			+ "1 2 3\r\n"
			+ "4 5 6\r\n"
			+ "4 9 0";
}
	