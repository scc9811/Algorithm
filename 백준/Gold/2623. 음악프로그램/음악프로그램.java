import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n+1];
        int[] inDegree = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 1; j < len; j++) {
                int to = Integer.parseInt(st.nextToken());
                inDegree[to]++;
                graph[from] = new Node(to, graph[from]);
                from = to;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append('\n');
            for(Node node=graph[cur]; node!=null; node=node.next){
                inDegree[node.to]--;
                if(inDegree[node.to]==0){
                    queue.add(node.to);
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(inDegree[i]!=0) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(sb);

    }
    static class Node{
        int to;
        Node next;
        Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
}
