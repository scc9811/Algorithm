import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Compare> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Compare(from, to, weight));
        }
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        long sum = 0;
        while(!priorityQueue.isEmpty()){
            Compare cur = priorityQueue.poll();
            if(find(parent, cur.from) == find(parent, cur.to)) continue;
            sum += cur.weight;
            union(parent, cur.from, cur.to);
        }
        System.out.println(sum);




    }
    static int find(int[] parent, int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent, parent[a]);
    }
    static void union(int[] parent, int a, int b){
        int p_a = find(parent, a);
        int p_b = find(parent, b);
        if(p_a != p_b) parent[p_a] = b;
    }
    static class Node{
        int to, weight;
        Node next;
        Node(int to, int weight, Node next){
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
    static class Compare implements Comparable<Compare>{
        int from, to, weight;
        Compare(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Compare c){
            return Integer.compare(this.weight, c.weight);
        }
    }

}
