package Algo_230920;

import java.util.*;

public class BJ_26083_S4_유통기한 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];

            switch (command) {
                case "add":
                    int x = Integer.parseInt(input[1]);
                    list.add(x);
                    break;

                case "check":
                    int y = Integer.parseInt(input[1]);
                    if (list.contains(y)) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;

                case "remove":
                    int z = Integer.parseInt(input[1]);
                    if (list.contains(z)) {
                        list.remove(Integer.valueOf(z));
                    }
                    break;

                case "toggle":
                    int w = Integer.parseInt(input[1]);
                    if (list.contains(w)) {
                        list.remove(Integer.valueOf(w));
                    } else {
                        list.add(w);
                    }
                    break;

                case "all":
                    list.clear();
                    for (int j = 1; j <= 20; j++) {
                        list.add(j);
                    }
                    break;

                case "empty":
                    list.clear();
                    break;
            }
        }
    }
}
