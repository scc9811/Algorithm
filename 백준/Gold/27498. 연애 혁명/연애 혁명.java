import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//        Node[] graph = new Node[n+1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int isLoved = Integer.parseInt(st.nextToken());
            if(isLoved==1){
                union(parent, from, to);
            }
            else priorityQueue.add(new Edge(from, to, weight));
        }
        int res = 0;
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(find(parent, e.from) == find(parent, e.to)) {
                res += e.weight;
                continue;
            }
            union(parent, e.from, e.to);
        }
        System.out.println(res);





    }
    public static class Edge implements Comparable<Edge>{
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
    public static void union(int[] parent, int a, int b){
        int a_p = find(parent, a);
        int b_p = find(parent, b);
        if(a_p < b_p) parent[b_p] = a_p;
        else parent[a_p] = b_p;
    }
    public static int find(int[] parent, int i){
        if(parent[i]==i) return i;
        return find(parent, parent[i]);
    }
//    public static class Node{
//        int to, weight;
//        Node next;
//        Node(int to, int weight, Node next){
//            this.to = to;
//            this.weight = weight;
//            this.next = next;
//        }
//    }
}
