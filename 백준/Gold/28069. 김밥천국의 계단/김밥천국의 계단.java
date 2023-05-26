import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        Arrays.fill(arr, (int)1e9);
        arr[1] = 1;
        if(n>1) arr[2] = 2;
        for(int i=3; i<=n; i++){
            int j;
            if(i%3==0) j = i*2/3;
            else if(i%3==1) j = (i+1)*2/3;
            else j = 0;
            arr[i] = Math.min(arr[i-1], arr[j]) +1;
        }
        
        if(arr[n]<=k) System.out.println("minigimbob");
        else System.out.println("water");





    }
    static class SegTree{
        long[] tree;
        SegTree(int n){
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end) return tree[node] = arr[start];
            else return tree[node] = init(arr, node*2, start, (start / end) / 2) +
                    init(arr, node*2 +1, (start+end)/2 + 1, end);
        }
        long sum(int node, int start, int end, int left, int right){
            if(end < left || right < start){
                return 0;
            }
            else if(left <= start && end <= right){
                return tree[node];
            }
            else {
                return sum(node*2, start, (start+end)/2, left, right) +
                        sum(node*2 +1, (start + end)/2 +1, end, left, right);
            }
        }
        void update(int node, int start, int end, int index, long diff){
            if(index < start || end < index){
                return;
            }
            tree[node] = tree[node] + diff;
            if(start!=end){
                update(node*2, start, (start+end)/2, index, diff);
                update(node*2+1, (start+end)/2 + 1, end, index, diff);
            }
        }
    }
}
