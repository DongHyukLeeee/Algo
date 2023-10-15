package Algo_2310007;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;


public class BJ_15683_감시 {
	static int N,M;
	static char map[][];
	static int res=  Integer.MAX_VALUE;
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(input2);
 		
 		N = sc.nextInt();
 		M = sc.nextInt();
 		int Numbers[] = new int[6];
 		map= new char[N][M];
 		
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<M; j++) {
 				char a = sc.next().charAt(0);
 				map[i][j]=a;
 				if(a=='1') {
 					Numbers[1]++;
 				}
 				else if(a=='2'){
 					Numbers[2]++;
 				}
 				else if(a=='3'){
 					Numbers[3]++;
 				}
 				else if(a=='4'){
 					Numbers[4]++;
 				}
 				else if(a=='5'){
 					Numbers[5]++;
 				}
 			}
 		}
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<M; j++) {
 				System.out.printf("%c ", map[i][j]);
 			}
 			System.out.println();
 		}
 		System.out.println(res);
 		System.out.println(Arrays.toString(Numbers));
 	}
 	
 	static void howManyzero() {
 		int cnt=0;
 		for(int i=0; i<N; i++) {
 			for(int j=0; j<M; j++) {
 			if(map[i][j]=='0') {
 				cnt++;
 			}
 			}
 		}
 		res = Math.min(cnt, res);
 		
 	}
 	static String input1 = "4 6\r\n"
 			+ "0 0 0 0 0 0\r\n"
 			+ "0 0 0 0 0 0\r\n"
 			+ "0 0 1 0 6 0\r\n"
 			+ "0 0 0 0 0 0";
 	static String input2 = "6 6\r\n"
 			+ "0 0 0 0 0 0\r\n"
 			+ "0 2 0 0 0 0\r\n"
 			+ "0 0 0 0 6 0\r\n"
 			+ "0 6 0 0 2 0\r\n"
 			+ "0 0 0 0 0 0\r\n"
 			+ "0 0 0 0 0 5";
}
