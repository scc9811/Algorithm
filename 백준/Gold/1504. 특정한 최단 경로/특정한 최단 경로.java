import java.util.*;
import java.io.*;

public class Main{
    static final int INF = (int)1e9 + 2;
    static int n, m;
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new Node[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
            graph[to] = new Node(from, weight, graph[to]);
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int dis1 = dijkstra(1, v1);
        int dis2 = dijkstra(v1, v2);
        int dis3 = dijkstra(v2, n);
        int res = -1;

        if(dis1!=INF && dis2!=INF && dis3!=INF){
            res = dis1+dis2+dis3;
        }

        dis1 = dijkstra(1, v2);
        dis2 = dijkstra(v2, v1);
        dis3 = dijkstra(v1, n);
        if(dis1!=INF && dis2!=INF && dis3!=INF){
            if(res==-1) res=dis1+dis2+dis3;
            else res = Math.min(res, dis1+dis2+dis3);
        }

        System.out.println(res);



    }
    static int dijkstra(int start, int end){
        int[] dis = new int[n+1];
        Arrays.fill(dis, INF);
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
//        System.out.printf("%d, %d\n", start, end);
//        System.out.println(Arrays.toString(dis));
//        System.out.println();
        return dis[end];
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