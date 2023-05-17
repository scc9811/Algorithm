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
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        SegTree segTree = new SegTree(n);
        segTree.init(arr, 1, 1, n);
        StringBuilder sb = new StringBuilder();
//        System.out.println(Arrays.toString(segTree.tree));


        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x>y){
                int tmp = x;
                x = y;
                y = tmp;
            }
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            sb.append(segTree.sum(1, 1, n, x, y)).append('\n');
            segTree.update(1, 1, n, a, b - arr[a]);
            arr[a] = b;
        }
        System.out.println(sb);


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
//    static class SegTree{
//        long[] tree;
//        SegTree(int n){
//            tree = new long[n*4];
//        }
//        long init(int[] arr, int node, int start, int end){
//            if(start==end) return tree[node] = arr[start];
//            else return tree[node] = init(arr, node*2, start, (start+end)/2) +
//                    init(arr, node*2+1, (start+end)/2+1, end);
//        }
//        long sum(int node, int start, int end, int left, int right){
//            if(end<left || start>right) return 0;
//            else if(start==end) return tree[node];
//            else return sum(node*2, start, (start+end)/2, left, right) +
//                        sum(node*2+1, (start+end)/2+1, end, left, right);
//        }
////        long update(int node, int start, int end, int index, long value){
////            if(index<start || index>end) return tree[node];
////            else if(start==end) return tree[node] = value;
////            else return tree[node] = update(node*2, start, (start+end)/2, index, value) +
////                        update(node*2+1, (start+end)/2+1, end, index, value);
////        }
//        void update2(int node, int start, int end, int index, long diff){
//            if(index<start || index>end) return;
//            tree[node] += diff;
//            if(start!=end){
//                update2(node*2, start, (start+end)/2, index, diff);
//                update2(node*2+1, (start+end)/2+1, end, index, diff);
//            }
//        }
//    }

