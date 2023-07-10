import java.util.*;
import java.io.*;

public class Main{
    static final int INF = (int)1e9 + 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dis = new int[n+1];

        int start = Integer.parseInt(br.readLine());
        Arrays.fill(dis, INF);
        Node[] graph = new Node[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }
        dis[start] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(Node node=graph[start]; node!=null; node=node.next){
            if(dis[node.to] > node.weight){
                dis[node.to] = node.weight;
                priorityQueue.add(new Edge(node.to, dis[node.to]));
            }
        }

        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(e.weight > dis[e.to]) continue;
            for(Node node=graph[e.to]; node!=null; node=node.next){
                if(dis[node.to] > dis[e.to] + node.weight){
                    dis[node.to] = dis[e.to] + node.weight;
                    priorityQueue.add(new Edge(node.to, dis[node.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(dis[i]==INF ? "INF" : dis[i]).append('\n');
        }
        System.out.println(sb);



    }
    static class Node{
        int to, weight;
        Node next;
        Node(int to, int weight, Node next){
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }
    }
}