import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
        }


        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(new Point(x, 0));
        visited[x] = true;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(Node node=graph[curP.to]; node!=null; node=node.next){
                if(visited[node.to]) continue;
                visited[node.to] = true;
                if(curP.dis==k-1) res.add(node.to);
                else queue.add(new Point(node.to, curP.dis+1));
            }
        }
        if(res.size()==0){
            System.out.println(-1);
            System.exit(0);
        }

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for(int i : res){
            sb.append(i).append('\n');
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
    static class Point{
        int to, dis;
        Point(int to, int dis){
            this.to = to;
            this.dis = dis;
        }
    }
}
