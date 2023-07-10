import java.io.*;
import java.util.*;
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
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Edge(from, to, weight));
        }
        int res = 0;
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(union(e.from, e.to)){
                res += e.weight;
            }
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
            return Integer.compare(this.weight, e.weight);
        }
    }
    static int[] par;
    static int find(int a){
        if(a==par[a]) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a!=p_b) {
            par[p_a] = p_b;
            return true;
        }
        return false;
    }
}