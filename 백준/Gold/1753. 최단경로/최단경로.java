import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[] weights = new int[v+1];
        int MAX_VALUE = (int) 1e9;
        Arrays.fill(weights, MAX_VALUE);
        weights[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node[] graph = new Node[v+1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }

        for (Node node = graph[k]; node != null; node = node.next) {
            if (weights[node.to] > node.weight) {
                weights[node.to] = node.weight;
                pq.add(new Node(node.to, node.weight, null));
            }
        }

        while (!pq.isEmpty()) {
            Node curN = pq.poll();
            if (weights[curN.to] < curN.weight) continue;

            for (Node node = graph[curN.to]; node != null; node = node.next) {
                if (weights[node.to] > weights[curN.to] + node.weight) {
                    weights[node.to] = weights[curN.to] + node.weight;
                    pq.add(new Node(node.to, weights[node.to], null));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (weights[i] == MAX_VALUE) sb.append("INF");
            else sb.append(weights[i]);
            sb.append('\n');
        }
        System.out.println(sb);




    }
    static class Node implements Comparable<Node>{
        int to, weight;
        Node next;
        Node (int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }
}
