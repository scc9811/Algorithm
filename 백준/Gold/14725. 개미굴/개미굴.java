import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            trie.insert(st);
        }
        print(trie.root, 0);
        System.out.println(sb);



    }

    static class Node {
        Map<String, Node> children = new HashMap<>();
    }

    static class Trie {
        Node root = new Node();

        void insert(StringTokenizer st) {
            Node node = root;
            while (st.hasMoreElements()) {
                String s = st.nextToken();
                node = node.children.computeIfAbsent(s, str -> new Node());
            }
        }
    }

    static void print(Node node, int depth) {
        List<String> list = new ArrayList<>(node.children.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < depth*2; j++) {
                sb.append('-');
            }
            sb.append(s).append('\n');
            print(node.children.get(s), depth+1);
        }
    }
}