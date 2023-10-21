package Algo_231020;

import java.util.*;

import java.io.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    boolean hasPrefix(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }
}

public class BJ_14426_접두사찾기2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(input1);
        int n = scanner.nextInt(); // 문자열의 개수 N
        int m = scanner.nextInt(); // 검사해야 하는 문자열의 개수 M

        Trie trie = new Trie();

        // 집합 S에 포함된 문자열을 트라이에 삽입
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            trie.insert(s);
        }

        int count = 0;

        // 검사해야 하는 문자열을 하나씩 트라이에서 검색
        for (int i = 0; i < m; i++) {
            String s = scanner.next();
            if (trie.hasPrefix(s)) {
                count++;
            }
        }

        System.out.println(count);
    }


	static String input1 = "5 10\r\n" + "baekjoononlinejudge\r\n" + "startlink\r\n" + "codeplus\r\n"
			+ "sundaycoding\r\n" + "codingsh\r\n" + "baekjoon\r\n" + "star\r\n" + "start\r\n" + "code\r\n"
			+ "sunday\r\n" + "coding\r\n" + "cod\r\n" + "online\r\n" + "judge\r\n" + "plus";

}
