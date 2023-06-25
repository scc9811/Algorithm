import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, arr[][], sequence[], res;
    static List<Point> location;
    static Point startP;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];



        location = new ArrayList<>();
        startP = null;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) location.add(new Point(i, j));
                else if(arr[i][j]==2){
                    startP = new Point(i, j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && (i%2+j%2)%2!=(startP.i%2+startP.j%2)%2){
                    System.out.println("Shorei");
                    System.exit(0);
                }
            }
        }

        System.out.println("Undertaker");
        sequence = new int[location.size()];
        visited = new boolean[location.size()];
        res =  (int)1e9;

        back(0);
        System.out.println(res);














    }
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,1,-1};
    static void back(int depth){
        if(depth==location.size()){
            Point last = startP;
            int sum = 0;
            for(int i=0; i<location.size(); i++) {
                sum += dis(last, location.get(sequence[i]));
                last = location.get(sequence[i]);
            }
            res = Math.min(res, sum);
        }

        for(int i=0; i<location.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            sequence[depth] = i;
            back(depth+1);
            visited[i] = false;
        }

    }
    static int dis(Point curP, Point nextP){
        int i = Math.abs(curP.i - nextP.i);
        int j = Math.abs(curP.j - nextP.j);
        return Math.max(i, j);
    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static class Node implements Comparable<Node>{
        int from, to, weight;
        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
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
