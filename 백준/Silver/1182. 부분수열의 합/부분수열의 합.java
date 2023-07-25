import java.util.*;
import java.io.*;

public class Main{
    static int n, s, arr[], res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = 0;
        back(0, 0);
        if(s==0) res--;
        System.out.println(res);




    }
    static void back(int idx, int sum){
        if(sum == s) res++;


        for(int i=idx; i<n; i++){
            back(i+1, sum + arr[i]);
        }



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
