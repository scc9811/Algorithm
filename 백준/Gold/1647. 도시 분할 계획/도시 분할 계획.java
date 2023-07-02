import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, par[], max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            priorityQueue.add(new Edge(from, to, weight));
        }
        max = - (int)1e9;
        System.out.println(mst(priorityQueue)-max);








    }
    static int mst(PriorityQueue<Edge> priorityQueue){
        int sum = 0;
        par = new int[n+1];
        for(int i=1; i<=n; i++){
            par[i] = i;
        }
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(find(e.from)==find(e.to)) continue;
            union(e.from, e.to);
            sum += e.weight;
            max = Math.max(max, e.weight);
        }

        return sum;
    }
    static int find(int a){
        if(a!=par[a]) return par[a] = find(par[a]);
        return a;
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a!=p_b) par[p_a] = p_b;
    }
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from =from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }
    }

    final static int MOD = 1000000007;
    static class SegTree {
        long[] tree;
        SegTree(int n){
            long treeHeight = (long)Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCount = (long)Math.pow(2,treeHeight);
            tree = new long[(int)treeNodeCount];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end) return tree[node] = arr[start];
            else return tree[node] = (init(arr, node*2, start, (start+end)/2) *
                    init(arr, node*2+1, (start+end)/2+1, end))%MOD;
        }
        long mul(int node, int start, int end, int left, int right){
            if(start>right || end<left) return 1;
            else if(start<=left && end>=right) return tree[node];
            else return (mul(node*2, start, end, left, (left+right)/2) *
                        mul(node*2+1, start, end, (left+right)/2+1, right))%MOD;
        }
        long update(int node, int start, int end, int index, long diff){
            if(start > index || end < index) return tree[node];
            if(start==end) return tree[node] = diff;
            return tree[node] = (update(node*2, start, (start+end)/2, index, diff)*
                    update(node*2, (start+end)/2+1, end, index, diff));
        }
    }
}
