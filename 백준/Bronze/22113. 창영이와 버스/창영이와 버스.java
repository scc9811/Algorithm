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
        StringTokenizer stM = new StringTokenizer(br.readLine());

        int[][] arr = new int[n+1][n+1];
        int[] mArray = new int[m];
        for(int i=0; i<m; i++){
            mArray[i] = Integer.parseInt(stM.nextToken());
        }
        for(int i=1; i<=n; i++){
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(tmp.nextToken());
            }
        }


        int res = 0;
        for(int i=1; i<m; i++){
            res += arr[mArray[i-1]][mArray[i]];
        }
        System.out.println(res);








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
