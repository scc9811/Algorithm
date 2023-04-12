import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, res;
    static int start, end;
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new Node[n+1];
        for(int i=0; i<m ;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from] = new Node(to, weight, graph[from]);
            graph[to] = new Node(from, weight, graph[to]);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        res = 0;


        int low = 1;
        int high = (int)1e9;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            boolean tf = function(mid);
            if(tf){
                res = Math.max(res, mid);
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        System.out.println(res);






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
    static boolean function(int limit){
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Node node=graph[cur]; node!=null; node=node.next){
                if(!visited[node.to] && node.weight>=limit){
                    if(node.to==end) return true;
                    visited[node.to] = true;
                    queue.add(node.to);
                }
            }
        }
        return false;
    }
}
