package Algo_230922;

import java.util.*;

public class SW_1987알파벳 {

    static int M, N;
    static boolean[][] visit;
    static boolean[] alphavisit =  new boolean[26];;
    static int res;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(input);
        M = sc.nextInt();
        N = sc.nextInt();
        res = Integer.MIN_VALUE;
        char[][] chararr = new char[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String temp = sc.next();
            for (int j = 0; j < N; j++) {
                chararr[i][j] = temp.charAt(j);
            }
        }
        dfs(chararr, 0,0,0);
        System.out.println(res);
    }

    public static void dfs(char[][] charArray, int StartI, int StartJ, int index) {
    	
    	int [] di = {-1,1,0,0};
    	int [] dj = {0,0,1,-1};
    	
    	if(alphavisit[charArray[StartI][StartJ]-'A']) {
    		res =Math.max(res,index); 
    		return;
    	}
    	else{
    		alphavisit[charArray[StartI][StartJ]-'A']=true;
    		for(int i=0; i<4; i++) {
    		int ni = StartI+di[i];
    		int nj = StartJ+dj[i];
    		if(isInArr(ni,nj)) {
    			dfs(charArray, ni,nj,index+1);
    		}
    	}
    		alphavisit[charArray[StartI][StartJ]-'A']=false;
    	}
    }

    public static boolean isInArr(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static String input = "5 5\r\n" + 
    "IEFCJ\r\n" + 
    "FHFKC\r\n" +
    "FFALF\r\n" + 
    "HFGCF\r\n" + 
    "HMCHH";
}
