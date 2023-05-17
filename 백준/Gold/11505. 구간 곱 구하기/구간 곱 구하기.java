import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        SegTree segTree = new SegTree(n);
        segTree.init(arr, 1, 1, n);
//        System.out.println(Arrays.toString(segTree.tree));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // update
            if(flag==1){
                segTree.update(1, 1, n, b, c);
            }
            // mul
            else{
//                System.out.println(Arrays.toString(segTree.tree));
//                System.out.println(segTree.mul(1, 1, n, b, c));
                sb.append(segTree.mul(1, 1, n, b, c)).append('\n');
            }
        }
        System.out.println(sb);
    }
    static long MOD = 1000000007;
    static class SegTree{
        long[] tree;
        SegTree(int n){
            tree = new long[n*4];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end) return tree[node] = arr[start];
            return tree[node] = (init(arr, node*2, start, (start+end)/2) *
                    init(arr, node*2+1, (start+end)/2+1, end))%MOD;
        }
        long mul(int node, int start, int end, int left, int right){
//            System.out.printf("mul(%d, %d, %d, %d, %d)\n", node, start, end, left, right);
//            if(start > right || end < left) return 1;
            if(left > end || right < start) return 1;
//            else if(start <= left && end >= right) return tree[node];
            else if(left <= start && right >= end) return tree[node];
            else return  (mul(node*2, start, (start+end)/2, left, right) *
                        mul(node*2+1, (start+end)/2+1, end, left, right))%MOD;
        }
        long update(int node, int start, int end, int index, long value){
            if(start > index || end < index) return tree[node];
            else if(start==index && end==index) return tree[node] = value;
            else return tree[node] = (update(node*2, start, (start+end)/2, index, value) *
                        update(node*2+1, (start+end)/2+1, end, index, value))%MOD;
        }
    }
}
