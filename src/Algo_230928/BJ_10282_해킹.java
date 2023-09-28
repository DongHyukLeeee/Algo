package Algo_230928;
import java.util.*;

public class BJ_10282_해킹 {
    static int V, E, InfestedCom;
    static ArrayList<Point>[] adjList;

    static class Point {
        int y, time;

        public Point(int y, int time) {
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int Tcase = sc.nextInt();
        for (int tc = 1; tc <= Tcase; tc++) {
            V = sc.nextInt(); // 컴퓨터 개수
            E = sc.nextInt(); // 의존성 개수
            InfestedCom = sc.nextInt() - 1; // 해킹당한 컴퓨터의 번호 (-1을 해서 0-based로 변환)
            adjList = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }

            // 의존성 정보 입력
            for (int i = 0; i < E; i++) {
                int a = sc.nextInt() - 1; // 의존 컴퓨터 번호 (-1을 해서 0-based로 변환)
                int b = sc.nextInt() - 1; // 의존되는 컴퓨터 번호 (-1을 해서 0-based로 변환)
                int c = sc.nextInt(); // 감염 시간

                // 의존성 역방향으로 저장 (b -> a)
                adjList[b].add(new Point(a, c));
            }

            int[] timeToInfest = new int[V];
            Arrays.fill(timeToInfest, Integer.MAX_VALUE);
            timeToInfest[InfestedCom] = 0; // 해킹당한 컴퓨터는 0초에 감염됨

            dijkstra(InfestedCom, timeToInfest);

            int maxTime = 0;
            int infectedCount = 0;

            for (int i = 0; i < V; i++) {
                if (timeToInfest[i] != Integer.MAX_VALUE) {
                    infectedCount++;
                    maxTime = Math.max(maxTime, timeToInfest[i]);
                }
            }

            System.out.println(infectedCount + " " + maxTime);
        }
    }

    static void dijkstra(int start, int[] timeToInfest) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        pq.add(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int curComputer = cur.y;
            int curTime = cur.time;

            if (curTime > timeToInfest[curComputer]) {
                continue; // 이미 최단 시간으로 감염되었다면 무시
            }

            for (Point next : adjList[curComputer]) {
                int nextComputer = next.y;
                int nextTime = curTime + next.time;

                if (nextTime < timeToInfest[nextComputer]) {
                    timeToInfest[nextComputer] = nextTime; // 최단 시간 업데이트
                    pq.add(new Point(nextComputer, nextTime)); // 다음 컴퓨터를 우선순위 큐에 추가
                }
            }
        }
    }

    static String input = "2\r\n"
            + "3 2 2\r\n"
            + "2 1 5\r\n"
            + "3 2 5\r\n"
            + "3 3 1\r\n"
            + "2 1 2\r\n"
            + "3 1 8\r\n"
            + "3 2 4";
}
