import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = n-1 + (long) (n - 1) *(n-2);
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append('\n');
        for(int i=1; i<n; i++){
            sb.append(1).append(' ').append(i+1).append('\n');
        }
        System.out.println(sb);




    }
    static class SegTree{
        long[] tree;
        SegTree(int n){
            long treeHeight = (long) Math.ceil(Math.log(n) / Math.log(2))+1;
            long treeNodeCount = (long) Math.pow(2, treeHeight);
            tree = new long[(int)treeNodeCount];
        }
        long init(long[] arr, int node, int start, int end){
            if(start==end) return arr[start];
            long tmpA = init(arr, node*2, start, (start+end)/2);
            long tmpB = init(arr, node*2+1, (start+end)/2+1, end);
            if(tmpA==0) return tree[node] = tmpB;
            else if(tmpB==0) return tree[node] = tmpA;
            else{
                return tree[node] = Math.min(tmpA, tmpB);
            }
        }
        long min(int node, int start, int end, int left, int right){
            if(end<left || start>right){
                return Integer.MAX_VALUE;
            }
            else if(left<=start && end<=right){
                return tree[node];
            }
            else {
                return Math.min(min(node*2, start, (start+end)/2, left, right),
                        min(node*2+1, (start+end)/2+1, end, left, right));
            }
        }

    }
}
