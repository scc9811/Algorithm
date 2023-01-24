import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] time = new int[v+1];
            Node[] edge = new Node[v+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=v; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[v+1];
            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edge[from] = new Node(to, edge[from]);
                inDegree[to]++;
            }
            int w = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int[] sum = new int[v+1];
            for(int i=1; i<=v; i++){
                if(inDegree[i]==0) {
                    queue.add(i);
                    sum[i] = time[i];
                }
            }
            if(sum[w]!=0){
                System.out.println(sum[w]);
                continue;
            }

            while(!queue.isEmpty()){
                int ver = queue.poll();
                if(ver==w) break;
                for(Node node=edge[ver]; node!=null; node=node.next){
                    sum[node.to] = Math.max(sum[node.to], sum[ver] + time[node.to]);
                    inDegree[node.to]--;
                    if(inDegree[node.to]==0) {
                        queue.add(node.to);
                    }
                }
            }
            System.out.println(sum[w]);
        }



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

