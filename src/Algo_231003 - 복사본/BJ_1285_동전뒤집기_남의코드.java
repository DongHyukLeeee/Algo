package Algo_231003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1285_동전뒤집기_남의코드 {
  static int N;
  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    
    // 입력을 받아 map 배열에 저장합니다.
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<N; j++) {
        map[i][j] = s.charAt(j);
      }
    }
    
    int answer = Integer.MAX_VALUE;
    
    // 비트마스크를 사용하여 가능한 모든 동전 뒤집기 조합을 시도합니다.
    for(int bit=1; bit < (1 << N); bit++) {
      int sum = 0;
      
      // 각 열에 대해 뒷면 개수를 계산합니다.
      for(int j=0; j<N; j++) {
        int back = 0;
        for(int i=0; i<N; i++) {
          char curr = map[i][j];
          if((bit & (1<<i)) != 0) {
            curr = reverse(curr);
          }
          if(curr == 'T')
            back++;
        }
        sum += Math.min(back, N-back);
      }
      
      // 현재 조합의 결과값을 최솟값과 비교하여 갱신합니다.
      answer = Math.min(answer, sum);
    }
    
    // 최종 결과를 출력합니다.
    System.out.println(answer);
  }
  
  // 'T'를 'H'로, 'H'를 'T'로 바꾸는 메서드입니다.
  public static char reverse(char curr) {
    if(curr == 'T')
      return 'H';
    else 
      return 'T';
  }
}
