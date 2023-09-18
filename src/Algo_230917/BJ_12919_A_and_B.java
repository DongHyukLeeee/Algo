package Algo_230917;

import java.io.*;

public class BJ_12919_A_and_B {

    public static int res;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        res = 0;
        String a = br.readLine();
        String bb = br.readLine();
        N = bb.length() - a.length();
        dfs(a, bb, 0);
        bw.write(String.valueOf(res));
        bw.newLine();
        bw.close();
    }

    public static void dfs(String x, String y, int index) {
        if (x.equals(y)) {
            res = 1;
            return;
        }
        if (index == N) {
            return;
        }
        
        if (y.endsWith("A")) {
            dfs(x, y.substring(0, y.length() - 1), index + 1);
        }
        
        if (y.startsWith("B")) {
            String reversed = new StringBuilder(y.substring(1)).reverse().toString();
            dfs(x, reversed, index + 1);
        }
    }
}
