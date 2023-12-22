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
        int k = Integer.parseInt(st.nextToken());

        long tmp = 0;

        for(int i=1; i<=n; i++){
            if(i/10==0){
                tmp = tmp*10 + i;
            }
            else if(i/100==0){
                tmp = tmp*100 + i;
            }
            else if(i/1000==0){
                tmp = tmp*1000 + i;
            }
            else if(i/10000==0){
                tmp = tmp*10000 + i;
            }
            else if(i/100000==0){
                tmp = tmp*100000 + i;
            }
            else if(i/1000000==0){
                tmp = tmp*1000000 + i;
            }
            else if(i/10000000==0){
                tmp = tmp*10000000 + i;
            }
            else if(i/100000000==0){
                tmp = tmp*100000000 + i;
            }
            tmp %= k;
        }
        System.out.println(tmp);








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
