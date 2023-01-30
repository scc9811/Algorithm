import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            graph[to] = new Node(from, graph[to]);
        }
        int[][] res = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(res[i], (int)1e9);
            for(Node node=graph[i]; node!=null; node=node.next){
                res[i][node.to] = 1;
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(j==k) continue;
                    res[j][k] = Math.min(res[j][k], res[j][i]+res[i][k]);
                }
            }
        }
        

        int min = (int)1e9;
        int minId = -1;
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                sum += res[i][j];
            }
            if(min>sum){
                min = sum;
                minId = i;
            }
        }
        System.out.println(minId);








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