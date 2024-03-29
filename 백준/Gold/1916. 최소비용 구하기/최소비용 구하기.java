import java.util.*;
import java.io.*;

public class Main {
    static final int INF = (int)1e9 + 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dis = new int[n+1];

        Arrays.fill(dis, INF);
        Node[] graph = new Node[n+1];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
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
        System.out.println(dis[end]);




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