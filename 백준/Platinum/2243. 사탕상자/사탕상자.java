import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int size = 4000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SegTree segTree = new SegTree();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
//            System.out.println("flag = "+flag);
            int b = Integer.parseInt(st.nextToken());
            if(flag==1){
//                System.out.println(segTree.get(1, 1, 1000000, b));
                sb.append(segTree.get(1, 1, 1000000, b)).append('\n');
            }
            else{
                long c = Long.parseLong(st.nextToken());
                segTree.update(1, 1, 1000000, b, c);
            }
//            for(int j=0; j<20; j++){
//                System.out.printf(segTree.tree[j]+" ");
//            }
//            System.out.println();
        }
        System.out.println(sb);
    }


    static class SegTree{
        long[] tree;
        SegTree(){
            tree = new long[size];
        }
        void update(int node, int start, int end, int index, long diff){
//            if(diff==-1) System.out.println("get_updated");
            if(start > index || end < index) return;
            tree[node] += diff;
            if(start!=end) {
                update(node*2, start, (start+end)/2, index, diff);
                update(node*2+1, (start+end)/2+1, end, index, diff);
            }
        }
        long get(int node, int start, int end, long cur){
            // leafNode
            if(start==end){
//                System.out.println("get_leaf");
                update(1, 1, 1000000, start, -1);
                return start;
            }
            else if(tree[node*2] < cur){
                return get(node*2+1, (start+end)/2+1, end, cur - tree[node*2]);
            }
            else{
                return get(node*2, start, (start+end)/2, cur);
            }
        }

    }
}
