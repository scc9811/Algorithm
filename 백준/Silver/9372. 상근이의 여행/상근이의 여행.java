import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
//            Node[] graph = new Node[n+1];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
//                int from = Integer.parseInt(st.nextToken());
//                int to = Integer.parseInt(st.nextToken());
//                graph[from] = new Node(to, graph[from]);
//                graph[to] = new Node(from, graph[to]);
            }
            sb.append(n-1).append('\n');
        }
        System.out.println(sb);








    }
//    public static class Node{
//        int to;
//        Node next;
//        Node(int to, Node next){
//            this.to = to;
//            this.next = next;
//        }
//    }
}