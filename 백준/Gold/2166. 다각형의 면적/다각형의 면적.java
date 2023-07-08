import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long sum = 0;
        for(int i=0; i<n-1; i++){
            sum += (long) arr[i].x * arr[i+1].y;
            sum -= (long) arr[i].y * arr[i+1].x;
        }
        sum += (long) arr[n-1].x * arr[0].y;
        sum -= (long) arr[n-1].y * arr[0].x;
        sum = Math.abs(sum);

        System.out.printf("%.1f", (double)sum/2);













    }
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
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
