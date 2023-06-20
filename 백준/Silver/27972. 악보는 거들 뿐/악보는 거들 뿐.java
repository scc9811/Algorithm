import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        if(n==1) {
            System.out.println(1);
            System.exit(0);
        }


        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int count = 1;
        int flag = 1;
        // 0 : equal, 1 : increase, 2 : decrease.

        int res = 0;
        for(int i=1; i<n; i++){
            if(flag==1){
                if(arr[i]>arr[i-1]) count++;
                else if(arr[i]<arr[i-1]){
                    res = Math.max(res, count);
                    count = 2;
                    flag = 2;
                }
            }
            else{
                if(arr[i]<arr[i-1]) count++;
                else if(arr[i]>arr[i-1]){
                    res = Math.max(res, count);
                    count = 2;
                    flag = 1;
                }
            }
        }
        res = Math.max(res, count);
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
