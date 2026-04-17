import java.util.*;
import java.io.*;
public class Main {
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        par = new int[n+1];
        for (int i = 1; i <= n; i++) {
           par[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(from, to, weight));
        }

        long sum = 0;
        int last = 0;
        while (!pq.isEmpty()) {
            Node curN = pq.poll();
            boolean tf = union(curN.from, curN.to);
            if (!tf) continue;
            sum += curN.weight;
            last = curN.weight;
        }
        System.out.println(sum - last);



    }
    static class Node implements Comparable<Node>{
        int from, to, weight;
        Node (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
        }
    }
    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        par[pb] = pa;
        return true;
    }
}
