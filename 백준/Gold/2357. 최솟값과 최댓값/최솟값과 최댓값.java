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
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        SegTree segTree = new SegTree(n);
        segTree.maxInit(arr, 1, 1, n);
        segTree.minInit(arr, 1, 1, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(segTree.min(1, 1, n, a, b)).append(' ');
            sb.append(segTree.max(1, 1, n, a, b));
            sb.append('\n');
        }
        System.out.println(sb);








    }
    static class SegTree{
        long[] maxTree;
        long[] minTree;
        SegTree(int n){
            long treeHeight = (long) Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCount = (long) Math.pow(2, treeHeight);
            maxTree = new long[(int)treeNodeCount];
            minTree = new long[(int)treeNodeCount];
        }
        long maxInit(long[] arr, int node, int start, int end){
            if(start==end) return maxTree[node] = arr[start];
            else return maxTree[node] = Math.max(maxInit(arr, node*2, start, (start+end)/2),
                    maxInit(arr, node*2+1, (start+end)/2+1, end));
        }
        long minInit(long[] arr, int node, int start, int end){
            if(start==end) return minTree[node] = arr[start];
            else return minTree[node] = Math.min(minInit(arr, node*2, start, (start+end)/2),
                    minInit(arr, node*2+1, (start+end)/2+1, end));
        }
        long max(int node, int start, int end, int left, int right){
            if(start>right || end<left) return Integer.MIN_VALUE;
            else if(left<=start && end<=right) return maxTree[node];
            else return Math.max(max(node*2, start, (start+end)/2, left, right),
                        max(node*2+1, (start+end)/2+1, end, left, right));
        }
        long min(int node, int start, int end, int left, int right){
            if(start>right || end<left) return Integer.MAX_VALUE;
            else if(left<=start && right>=end) return minTree[node];
            else return  Math.min(min(node*2, start, (start+end)/2, left, right),
                        min(node*2+1, (start+end)/2+1, end, left, right));
        }

    }
}
