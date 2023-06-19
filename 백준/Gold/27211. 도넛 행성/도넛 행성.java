import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m, arr[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0 && !visited[i][j]){
                    visited[i][j] = true;
                    res++;
                    BFS(new Point(i, j));
                }
            }
        }
        System.out.println(res);










    }
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static void BFS(Point startP){
        Queue<Point> queue = new LinkedList<>();
        queue.add(startP);
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.x + dx[i];
                int newJ = curP.y + dy[i];
                if(newI==-1) newI = n-1;
                else if(newI==n) newI = 0;
                if(newJ==-1) newJ = m-1;
                else if(newJ==m) newJ = 0;
                if(arr[newI][newJ]==0 && !visited[newI][newJ]){
                    queue.add(new Point(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }
        }
    }

    static final int MOD = 1000000007;
    static class SegTree {
        private long[] tree;

        SegTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) +1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end){
                return tree[node] = arr[start];
            }
            else {
                return tree[node] = (init(arr, node*2, start, (start+end)/2)  *
                        init(arr, node*2 +1, (start+end)/2 + 1, end))%MOD;
            }
        }
        long mul(int node, int start, int end, int left, int right){
            if(end < left || right < start){
                return 1;
            }
            else if(left <= start && end <= right){
                return tree[node];
            }
            else{
                return (mul(node*2, start, (start + end) / 2, left, right) *
                        mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right))%MOD;
            }
        }

        void update(int node, int start, int end, int index, long diff){
            if(index < start || end < index){
                return;
            }
            tree[node] = (tree[node]*diff)%MOD;
            if(start!=end){
                update(node*2, start, (start + end)/2, index, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);


            }
        }
    }
}
