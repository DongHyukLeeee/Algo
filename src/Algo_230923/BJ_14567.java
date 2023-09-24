package Algo_230923;
import java.util.*;

public class BJ_14567 {
    static int N; 
    static int P[];
    static int rank[];
    
    static int find(int x) {
        if (P[x] != x) {
            x = P[x]; // 경로 압축
        }
        return P[x];
    }
    
    static public void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        P[y]=x;
      

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        
        N = sc.nextInt();
        P = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = i;
            rank[i] = 1;
        }
        int M = sc.nextInt();
        int[][] Edges = new int[M][2];
        
        for (int i = 0; i < M; i++) {
            Edges[i][0] = sc.nextInt();
            Edges[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            union(Edges[i][0], Edges[i][1]);
        }
        
        // 루트 노드를 찾아 출력

        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(rank));
        System.out.println(findParentNum(3,0));
    }

    static int findParentNum(int x, int cnt) {
    	if(x==P[x]) {
    		return cnt;
    	}
    	else {
    		return findParentNum(P[x],cnt+1);
    	}
    	
    }
	
	static String input = "4 2\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			;
}