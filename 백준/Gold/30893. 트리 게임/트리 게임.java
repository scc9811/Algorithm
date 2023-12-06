import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Node[] tree = new Node[n+1];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from] = new Node(to, tree[from]);
            tree[to] = new Node(from, tree[to]);
        }

        boolean[] visited = new boolean[n+1];
        int[] parNodeNum = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Node node = tree[cur]; node!=null; node=node.next){
                if(!visited[node.to]){
                    visited[node.to] = true;
                    parNodeNum[node.to] = cur;
                    queue.add(node.to);
                    if(node.to == e) break;
                }
            }
        }
//        System.out.println(Arrays.toString(parNodeNum));
        List<Integer> list = new ArrayList<>();
        for(int i=e; i!=s; i=parNodeNum[i]){
            list.add(i);
        }
        list.add(s);
        int size = list.size();
//        System.out.println(list);
        visited = new boolean[n+1];
        boolean turn = true;
        for(int i=size-1; i>=1; i--){
            int count = 0;
            int cur = list.get(i);
            for(Node node=tree[cur]; node!=null; node=node.next){
                if(!visited[node.to]) count++;
            }
            if(!turn && count>1){
                System.out.println("Second");
                System.exit(0);
            }
            visited[cur] = true;
            if(turn) turn = false;
            else turn = true;
        }

        System.out.println("First");








    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Node{
        int to;
        Node next;
        Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}