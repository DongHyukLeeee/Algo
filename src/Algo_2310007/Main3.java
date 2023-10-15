package Algo_2310007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	static int topni[][];
	static int[][] rotation;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		topni = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String temp = sc.next();
			for (int j = 0; j < 8; j++) {
				topni[i][j] = temp.charAt(j)-'0';
			}
		}
		int N = sc.nextInt();
		rotation = new int[N][2];
		for (int i = 0; i < N; i++) {
			rotation[i][0] = sc.nextInt();
			rotation[i][1] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%d " , topni[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for(int l=0; l<N; l++) {
			int a = rotation[l][0]-1;
			int b = rotation[l][1];
			if(b==1) {
				rotate(true, a);
				afterrotate(a, true);
			}
			else {
				rotate(false, a);
				afterrotate(a, false);
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.printf("%d " , topni[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
		}
		
		int sum = 0;
		for(int i=0; i<4 ;i++) {
			sum+=topni[i][0]*Math.pow(2, i);
		}
		System.out.println(sum);
			
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%d " , topni[i][j]);
			}
			System.out.println();
		}

	}
	static void afterrotate(int index, boolean clock) {
			int leftIndex = index - 1;
		    int rightIndex = index + 1;
		    
		    boolean currentClockwise = clock;

		    // Rotate to the left
		    while (leftIndex >= 0) {
		        if (topni[leftIndex][6] != topni[leftIndex + 1][2]) {
		            currentClockwise = !currentClockwise;
		            rotate(currentClockwise, leftIndex);
		        } else {
		            break;
		        }
		        leftIndex--;
		    }

		    currentClockwise = clock; // Reset direction

		    // Rotate to the right
		    while (rightIndex < 4) {
		        if (topni[rightIndex][2] != topni[rightIndex - 1][6]) {
		            currentClockwise = !currentClockwise;
		            rotate(currentClockwise, rightIndex);
		        } else {
		            break;
		        }
		        rightIndex++;
		    }
	}

	static void rotate(boolean clock, int index) {
		int temp[] = new int[8];
		if (clock) {

			for (int j = 1; j < 8; j++) {
				temp[j] = topni[index][(j - 1)];
			}
			temp[0] = topni[index][7];

		} else {

			for (int j = 0; j < 7; j++) {
				temp[j] = topni[index][(j + 1)];
			}
			temp[7] = topni[index][0];
		}
		for (int i = 0; i < 8; i++) {
			topni[index][i] = temp[i];

		}
	}

	static String input1 = "10101111\r\n"
			+ "01111101\r\n"
			+ "11001110\r\n"
			+ "00000010\r\n"
			+ "2\r\n"
			+ "3 -1\r\n"
			+ "1 1";
}