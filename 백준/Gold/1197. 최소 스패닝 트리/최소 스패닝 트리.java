import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Edge(from, to, weight));
        }
        int res = 0;
        int[] parent = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(find(parent, edge.from)==find(parent, edge.to)) continue;
            res += edge.weight;
            union(parent, edge.from, edge.to);
        }
        System.out.println(res);











    }
    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        if(x<y) parent[y] = x;
        else parent[x] = y;
    }
    public static int find(int[] parent, int x){
        if(parent[x]==x) return x;
        return find(parent, parent[x]);
    }

    public static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge edge){
            return Integer.compare(this.weight, edge.weight);
        }
    }
}

