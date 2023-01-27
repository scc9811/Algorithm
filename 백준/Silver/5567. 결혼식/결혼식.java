import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Node[] graph = new Node[n+1];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            graph[to] = new Node(from, graph[to]);
        }
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int count = 0;
        for(Node node=graph[1]; node!=null; node=node.next){
            if(!visited[node.to]) {
                visited[node.to] = true;
                count++;
            }
            for(Node secondN=graph[node.to]; secondN!=null; secondN=secondN.next){
                if(!visited[secondN.to]){
                    visited[secondN.to] = true;
                    count++;
                }
            }
        }
        System.out.println(count);






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

