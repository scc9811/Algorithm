import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            nodes = new Node[v];
            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                nodes[start] = new Node(end, nodes[start]);
                nodes[end] = new Node(start, nodes[end]);
            }
            boolean tf = BFS();
            if(tf) System.out.println("YES");
            else System.out.println("NO");


        }


    }
    static int[] color;
    static Queue<Integer> queue;
    static public boolean BFS(){
        queue = new LinkedList<>();
        queue.add(0);
        color = new int[v];
        color[0] = 1;
        while(true){
            if(queue.isEmpty()){
                check();
                if(queue.isEmpty()) break;
            }
            int start = queue.poll();
            int startColor = color[start];
            for(Node node = nodes[start]; node!=null; node = node.next){
                if(color[node.to]==0){
                    color[node.to] = -startColor;
                    queue.add(node.to);
                }
                else if(startColor==color[node.to]) return false;
            }

        }
        return true;
    }
    public static void check(){
        for(int i=0; i<v; i++){
            if(color[i]==0){
                color[i] = 1;
                queue.add(i);
                return;
            }
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