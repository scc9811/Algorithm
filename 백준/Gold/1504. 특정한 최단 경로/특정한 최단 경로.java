import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int n, e;
    static Node[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new Node[n+1];
        for(int i=0; i<e; i++){
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


        // case1
        int dis1 = Dijkstra(1, v1);
        int dis2 = Dijkstra(v1, v2);
        int dis3 = Dijkstra(v2, n);
        int case1 = dis1+dis2+dis3;

        dis1 = Dijkstra(1, v2);
        dis2 = Dijkstra(v2, v1);
        dis3 = Dijkstra(v1, n);
        int case2 = dis1+dis2+dis3;
        int res;

        if(case1<0){
            if(case2<0) res = -1;
            else res = case2;
        }
        else{
            if(case2<0) res = case1;
            else res = Math.min(case1, case2);
        }
        System.out.println(res);











    }
    static int Dijkstra(int start, int end){
        if(start==end) return 0;
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[start] = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        while(!priorityQueue.isEmpty()){
            Node cur = priorityQueue.poll();
            if(end==cur.to) return cur.weight;
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            for(Node node=graph[cur.to]; node!=null; node=node.next) {
                if (distance[node.to] > node.weight + cur.weight) {
                    distance[node.to] = node.weight + cur.weight;
                    priorityQueue.add(new Node(node.to, distance[node.to]));
                }
            }
        }
        return (int) -1e9/2;
    }
    static class Node implements Comparable<Node>{
        int to, weight;
        Node next;
        Node(int to, int weight, Node next){
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
        }

    }
}
