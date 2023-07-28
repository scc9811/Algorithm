import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n+1];
        int nameCount = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String par = st.nextToken();
            String child = st.nextToken();
            if(!map.containsKey(par)) map.put(par, nameCount++);
            if(!map.containsKey(child)) map.put(child, nameCount++);

            graph[map.get(child)] = new Node(map.get(par), graph[map.get(child)]);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        mainLoop:
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(!map.containsKey(a) || !map.containsKey(b)){
                sb.append("gg").append(' ');
                continue;
            }
            int x = map.get(a);
            int y = map.get(b);
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);
            visited[x] = true;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(Node node=graph[cur]; node!=null; node=node.next){
                    if(!visited[node.par]){
                        if(node.par == y){
                            sb.append(b).append(' ');
                            continue mainLoop;
                        }
                        visited[node.par] = true;
                        queue.add(node.par);
                    }
                }
            }

            queue.add(y);
            visited = new boolean[n+1];
            visited[y] = true;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(Node node=graph[cur]; node!=null; node=node.next){
                    if(!visited[node.par]){
                        if(node.par == x){
                            sb.append(a).append(' ');
                            continue mainLoop;
                        }
                        visited[node.par] = true;
                        queue.add(node.par);
                    }
                }
            }
            sb.append("gg").append(' ');
        }
        System.out.println(sb);



    }
    static class Node{
        int par;
        Node next;
        Node(int par, Node next){
            this.par = par;
            this.next = next;
        }
    }
}