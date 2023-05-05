import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        SegTree segTree = new SegTree(n);
        segTree.init(arr, 1, 1, n);


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(segTree.min(1, 1, n, a, b)).append('\n');
        }
        System.out.println(sb);









    }
    static class SegTree{
        long[] tree;
        SegTree(int n){
            long treeHeight = (long) Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCount = (long) Math.pow(2, treeHeight);
            tree = new long[(int)treeNodeCount];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end) return tree[node] = arr[start];
            else return tree[node] = Math.min(init(arr, node*2, start, (start+end)/2),
                    init(arr, node*2+1, (start+end)/2 +1, end));
        }
        long min(int node, int start, int end, int left, int right){
            if(left>end || right<start) return Integer.MAX_VALUE;
            else if(left<= start && end<=right) return tree[node];
            else return Math.min(min(node*2, start, (start+end)/2, left, right),
                        min(node*2+1, (start+end)/2+1, end, left, right));
        }
    }
}
