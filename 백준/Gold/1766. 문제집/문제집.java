import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n+1];
        int[] inDegree = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            inDegree[to]++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                priorityQueue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            int k = priorityQueue.poll();
            sb.append(k).append(' ');
            for(Node node=graph[k]; node!=null; node=node.next){
                inDegree[node.to]--;
                if(inDegree[node.to]==0) priorityQueue.add(node.to);
            }
        }
        System.out.println(sb);









    }
    public static class Node{
        int to;
        Node next;
        Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
}

