import javax.swing.text.Segment;
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
        Set<Double> set = new LinkedHashSet<>();
        for(int i1=0; i1<=n; i1++){
            for(int i2=0; i2<=m; i2++){
                for(int j1=0; j1<=n; j1++){
                    for(int j2=0; j2<=m; j2++){
                        for(int k1=0; k1<=n; k1++){
                            for(int k2=0; k2<=m; k2++){
                                if((i1==j1 && j1==k1) || (i2==j2 && j2==k2)) continue;
                                if((i1==j1 && i2==j2) || (j1==k1 && j2==k2) || (k1==i1 && k2==i2)) continue;
                                if( (i2-j2) * (j1-k1) == (j2-k2) * (i1-j1)) continue;
                                double[] dis = new double[3];
                                dis[0] = Math.sqrt(Math.pow(i1-j1, 2) + Math.pow(i2 - j2, 2));
                                dis[1] = Math.sqrt(Math.pow(j1-k1, 2) + Math.pow(j2 - k2, 2));
                                dis[2] = Math.sqrt(Math.pow(i1-k1, 2) + Math.pow(i2 - k2, 2));
                                Arrays.sort(dis);
//                                System.out.printf("(%d, %d), (%d, %d), (%d, %d)\n",i1, i2, j1, j2, k1, k2);
//                                System.out.println("dis = "+dis[0]*10000 + dis[1]*100 + dis[0]);
                                set.add(dis[0]*10000 + dis[1]*100 + dis[2]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(set.size());







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
