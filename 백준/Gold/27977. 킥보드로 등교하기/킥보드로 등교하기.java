import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int l, n, k, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = l;
        int mid;
        int res = (int)1e9;
        while(low<=high){
            mid = (low+high)/2;
            int visited = visit(mid);
            if(visited==-1) low = mid+1;
            else if(visited<=k){
                res = Math.min(res, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        System.out.println(res);









    }
    static int visit(int bet){
        int dis = bet;
        int visited = 0;
        int tmp = bet;
        for(int i=0; i<n; i++){
            if(arr[i]<dis){
                tmp = arr[i] + bet;
            }
            else if(arr[i]==dis){
                dis = arr[i] + bet;
                visited++;
                tmp = arr[i] + bet;
            }
            else{
                if(tmp<arr[i]){
                    return -1;
                }
                else if(tmp==arr[i]){
                    dis = arr[i] + bet;
                    visited += 2;
                    tmp = arr[i] + bet;
                }
                // tmp > arr[i]
                else{
                    dis = tmp;
                    visited++;
                    tmp = arr[i] + bet;
                }
            }

        }
        if(dis<l){
            if(tmp<l) return -1;
            else return visited+1;
        }
        return visited;


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
