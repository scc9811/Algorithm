import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int[] time = new int[v+1], sumTime = new int[v+1], inDegree = new int[v+1];
        Node[] graph = new Node[v+1];
        for(int i=1; i<=v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int from = Integer.parseInt(st.nextToken());
                if(from==-1) break;
                graph[from] = new Node(i, graph[from]);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=v; i++){
            if(inDegree[i]==0){
                queue.add(i);
                sumTime[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int ver = queue.poll();
            for(Node node=graph[ver]; node!=null; node=node.next){
                sumTime[node.to] = Math.max(sumTime[node.to], sumTime[ver] + time[node.to]);
                inDegree[node.to]--;
                if(inDegree[node.to]==0) queue.add(node.to);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++){
            sb.append(sumTime[i]).append('\n');
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