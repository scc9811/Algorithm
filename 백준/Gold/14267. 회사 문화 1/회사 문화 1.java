import java.util.*;
import java.io.*;


public class Main {
    static int n;
    static long[] count;
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new Node[n+1];

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=2; i<=n; i++){
            int p = Integer.parseInt(st.nextToken());
            graph[p] = new Node(i, graph[p]);
        }
        count = new long[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            count[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        BFS(1, 0);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(count[i]).append(' ');
        }
        System.out.println(sb);




    }
    static void BFS(int nodeNum, long cur){
        count[nodeNum] += cur;
        for(Node node=graph[nodeNum]; node!=null; node=node.next){
            BFS(node.child, count[nodeNum]);
        }
    }
    static class Node{
        int child;
        Node next;
        Node(int child, Node next){
            this.child = child;
            this.next = next;
        }
    }
}


