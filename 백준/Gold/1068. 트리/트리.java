import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node[] tree = new Node[n];
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            if(k!=-1) tree[k] = new Node(i, tree[k]);
        }
        int del = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(del);
        boolean[] visited = new boolean[n];
        visited[del] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Node node=tree[cur]; node!=null; node=node.next){
                queue.add(node.to);
                visited[node.to] = true;
            }
        }


        int res = 0;
        loop:
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            for(Node node=tree[i]; node!=null; node=node.next){
                if(!visited[node.to]) continue loop;
            }
            res++;
//            if(tree[i]==null && !visited[i]) res++;
        }
        System.out.println(res);


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
