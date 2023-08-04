import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][m+1];

        dp[1] = Arrays.copyOf(arr[1], m+1);

        for(int i=2; i<=n; i++){
            int[] tmpArray = Arrays.copyOfRange(dp[i-1], 1, m+1);
            Arrays.sort(tmpArray);
            int minFst = tmpArray[0];
            int minSec = tmpArray[1];
            for(int j=1; j<=m; j++){
                if(minFst==dp[i-1][j]) dp[i][j] = arr[i][j] + minSec;
                else dp[i][j] = arr[i][j] + minFst;
            }
        }

        int min = (int)1e9;
        for(int i=1; i<=m; i++){
            min = Math.min(dp[n][i], min);
        }

        System.out.println(min);






    }
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
                return tree[node] = init(arr, node*2, start, (start+end)/2)  +
                        init(arr, node*2 +1, (start+end)/2 + 1, end);
            }
        }
        long sum(int node, int start, int end, int left, int right){
            if(end < left || right < start){
                return 0;
            }
            else if(left <= start && end <= right){
                return tree[node];
            }
            else{
                return sum(node*2, start, (start + end) / 2, left, right) +
                        sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            }
        }

        void update(int node, int start, int end, int index, long diff){
            if(index < start || end < index){
                return;
            }
            tree[node] = tree[node] + diff;
            if(start!=end){
                update(node*2, start, (start + end)/2, index, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);


            }
        }
    }
}
