import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        Node[] graph = new Node[v+1];
        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[v+1];
        Arrays.fill(distance, (int)1e9);
        boolean[] visited = new boolean[v+1];
        visited[start] = true;
        PriorityQueue<Compare> priorityQueue = new PriorityQueue<>();
        for(Node node=graph[start]; node!=null; node=node.next){
            distance[node.to] = Math.min(distance[node.to], node.weight);
            priorityQueue.add(new Compare(node.to, distance[node.to]));
        }
        while(!priorityQueue.isEmpty()){
            Compare now = priorityQueue.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node node=graph[now.to]; node!=null; node=node.next){
                distance[node.to] = Math.min(distance[node.to], distance[now.to] + node.weight);
                priorityQueue.add(new Compare(node.to, distance[node.to]));
            }
        }

        System.out.println(distance[end]);











    }
    public static class Compare implements Comparable<Compare>{
        int to, weight;
        Compare(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Compare compare){
            return Integer.compare(this.weight, compare.weight);
        }

    }
    public static class Node{
        int to, weight;
        Node next;
        Node(int to, int weight, Node next){
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
}