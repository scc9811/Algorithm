import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        Node[] graph = new Node[v+1];
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }

        int[] weight = new int[v+1];
        Arrays.fill(weight, (int)1e9);
        for(Node node=graph[startNode]; node!=null; node=node.next){
            weight[node.to] = Math.min(weight[node.to], node.weight);
        }
        
        boolean[] visited = new boolean[v+1];
        visited[startNode] = true;
        while(true){
            int min = (int)1e9;
            int minNode = -1;
            for(int i=1; i<=v; i++){
                if(!visited[i] && weight[i]<min){
                    min = weight[i];
                    minNode = i;
                }
            }
            if(minNode==-1) break;
            visited[minNode] = true;
            for(Node node=graph[minNode]; node!=null; node=node.next){
                weight[node.to] = Math.min(weight[node.to], weight[minNode]+node.weight);
            }
        }
        weight[startNode] = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++){
            if(weight[i]==(int)1e9) sb.append("INF");
            else sb.append(weight[i]);
            sb.append('\n');
        }
        System.out.println(sb);











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

