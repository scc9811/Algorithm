import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Edge(a, b, c));
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int res = (int)1e9;
        while(find(from) != find(to)){
            Edge e = priorityQueue.poll();
            assert e != null;
            res = Math.min(res, e.weight);
            union(e.from, e.to);
        }
        System.out.println(res);

    }
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Integer.compare(e.weight, this.weight);
        }
    }

    static int[] par;

    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        par[p_b] = p_a;
    }
}