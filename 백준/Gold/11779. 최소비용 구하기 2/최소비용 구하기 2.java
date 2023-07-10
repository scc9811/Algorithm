import java.util.*;
import java.io.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
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

        long[] dis = new long[n+1];
        Arrays.fill(dis, (int)1e18);
        dis[start] = 0;
        int[] par = new int[n+1];


        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(dis[e.to] < e.weight) continue;
            for(Node node=graph[e.to]; node!=null; node=node.next){
                if(dis[node.to] > dis[e.to] + node.weight){
                    dis[node.to] = dis[e.to] + node.weight;
                    priorityQueue.add(new Edge(node.to, dis[node.to]));
                    par[node.to] = e.to;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(dis[end]).append('\n');
        List<Integer> list = new ArrayList<>();
        list.add(end);
        for(int i=par[end]; i!=start; i=par[i]){
            list.add(i);
        }
        list.add(start);
        sb.append(list.size()).append('\n');
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(' ');
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
        int to;
        long weight;
        Edge(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Long.compare(this.weight, e.weight);
        }
    }
}
