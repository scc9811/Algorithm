import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new Node[n+1];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            tree[from] = new Node(to, dis, tree[from]);
            tree[to] = new Node(from, dis, tree[to]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(BFS(from, to)).append('\n');
        }
        System.out.println(sb);



    }
    static int BFS(int from, int to){
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[from] = true;
        queue.add(new Point(from, 0));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(Node node=tree[p.nodeNum]; node!=null; node=node.next){
                if(visited[node.to]) continue;
                if(node.to==to) return p.count+ node.dis;
                queue.add(new Point(node.to, p.count+node.dis));
                visited[node.to] = true;
            }
        }
        return -1;
    }
    static class Point{
        int nodeNum, count;
        Point(int nodeNum, int count){
            this.nodeNum = nodeNum;
            this.count = count;
        }
    }
    static class Node{
        int to, dis;
        Node next;
        Node(int to, int dis, Node next){
            this.to = to;
            this.dis = dis;
            this.next = next;
        }
    }
}
