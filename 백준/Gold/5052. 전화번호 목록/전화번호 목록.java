import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        loop:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
                trie.insert(arr[i]);
            }
            for (int i = 0; i < n; i++) {
                if(trie.isPrefix(arr[i])) {
                    sb.append("NO").append('\n');
                    continue loop;
                }
            }
            sb.append("YES").append('\n');
        }
        System.out.println(sb);


    }
    static class Node {
        Map<Character, Node> childs = new HashMap<>();
        boolean isLast;
    }

    static class Trie {
        Node root = new Node();

        void insert(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                // 없으면 자식노드 새로 생성후 반환해 받아옴.
                node = node.childs.computeIfAbsent(s.charAt(i), c -> new Node());
            }
            node.isLast = true;
        }

        boolean isPrefix(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!node.childs.containsKey(c)) return false;
                node = node.childs.get(c);
            }
            // 마지막 노드 + child node 존재 여부 확인
            return (node.isLast && !node.childs.isEmpty());
        }
    }
}