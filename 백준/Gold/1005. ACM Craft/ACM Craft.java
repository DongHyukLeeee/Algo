import java.util.*;


public class Main {
		
		static ArrayList<Integer>[] list;
		static int [] weightEach, weightTotal,degree;
		static int V,E;
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Tcase= sc.nextInt();
        for(int tc=1 ;tc<=Tcase; tc++) {
        V = sc.nextInt();
        E = sc.nextInt();
        weightTotal = new int [V];
        weightEach = new int[V];
        degree = new int[V];
        list =new ArrayList[V];
        for(int i=0; i<V; i++) {
        	list[i]=new ArrayList<>();
        }
        
        for(int i=0; i<V; i++) {
        	weightEach[i]=sc.nextInt();
        }
        for(int i=0; i<E; i++) {
        	int A=sc.nextInt()-1;
        	int B=sc.nextInt()-1;
        	
        	list[A].add(B);
        	degree[B]++;
        	
        }
        topologySort();
        System.out.println(weightTotal[sc.nextInt()-1]);
        	
        }
         sc.close();
    } 
    
    public static void topologySort() {
    	
    	Queue <Integer> q = new LinkedList<>();
    	
    	for(int i=0; i<V; i++) {
    		if(degree[i]==0) {
    			weightTotal[i]=weightEach[i];
    			q.add(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for(int i=0; i<list[cur].size(); i++) {
    			int next = list[cur].get(i);
    			weightTotal[next] = Math.max(weightTotal[next], weightEach[next]+weightTotal[cur]);
    			degree[next]--;
    			if(degree[next]==0) q.add(next);
    		}
    		
    	}
    	
    		
    		
   
    }

    public static String input = "2\r\n" + 
    		"4 4\r\n" + 
    		"10 1 100 10\r\n" + 
    		"1 2\r\n" + 
    		"1 3\r\n" + 
    		"2 4\r\n" + 
    		"3 4\r\n" + 
    		"4\r\n" + 
    		"8 8\r\n" + 
    		"10 20 1 5 8 7 1 43\r\n" + 
    		"1 2\r\n" + 
    		"1 3\r\n" + 
    		"2 4\r\n" + 
    		"2 5\r\n" + 
    		"3 6\r\n" + 
    		"5 7\r\n" + 
    		"6 7\r\n" + 
    		"7 8\r\n" + 
    		"7";
}
