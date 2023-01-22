import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[n+1];
        Node[] graph = new Node[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> res = new ArrayList<>();


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            inDegree[back]++;
            graph[front] = new Node(back, graph[front]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                visited[i] = true;
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int k = queue.poll();
            res.add(k);
            for(Node node=graph[k]; node!=null; node=node.next){
                inDegree[node.to]--;
            }
            for(int i=1; i<=n; i++){
                if(!visited[i] && inDegree[i]==0){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : res){
            sb.append(i).append(' ');
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

