package Algo_230922;

import java.lang.reflect.Array;
import java.util.*;


public class BJ_2667_단지번호붙히기 {

    static int N;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] isVisited;
    
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        
        N = sc.nextInt();
        ArrayList <Integer> villageNum = new ArrayList<>();
        int map[][] = new int[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        int townNum=0;
        for(int i=0; i<N ;i++) {
        	for(int j=0; j<N ;j++) {
        		if(!isVisited[i][j]&&map[i][j]==1) {
        			villageNum.add(bfs(map,i,j,isVisited));
        			townNum++;
        		}
        	}
        }
        // 여기에 원하는 작업을 수행하는 코드를 추가하세요.
        System.out.println(townNum);
        Collections.sort(villageNum);
        for(int a : villageNum) {
        	System.out.println(a);
        }
        sc.close(); // 사용이 끝난 Scanner 객체를 닫아줍니다.
    }

    static int bfs(int[][] map, int StartI, int StartJ, boolean isVisited[][]) {
        int N = map.length;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(StartI, StartJ));
        isVisited[StartI][StartJ] = true;

        int maxi = 1 ;
        while (!q.isEmpty()) {
            Point current = q.poll();
            int currI = current.x;
            int currJ = current.y;
            for (int i = 0; i < 4; i++) {
                int ni = currI + di[i];
                int nj = currJ + dj[i];

                if (isInArr(ni, nj) && !isVisited[ni][nj]  && map[ni][nj] == 1) {
                    q.add(new Point(ni, nj));
                    isVisited[ni][nj] = true;
                    maxi++;
                }
            }
        }

        return maxi;

    }

    public static boolean isInArr(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    static String input = "7\r\n"
    		+ "0110100\r\n"
    		+ "0110101\r\n"
    		+ "1110101\r\n"
    		+ "0000111\r\n"
    		+ "0100000\r\n"
    		+ "0111110\r\n"
    		+ "0111000";

}
