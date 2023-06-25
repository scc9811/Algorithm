import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while(n!=0){
            String s = String.valueOf(n);
            if(s.contains("1")){
                StringBuilder sb = new StringBuilder();
                int flag = 0;
                for(int i=0; i<s.length(); i++){
                    if(s.charAt(i)=='1' && flag==0) {
                        flag++;
                    }
                    else sb.append(s.charAt(i));
                }

                int pointer = 0;
                for(int i=0; i<sb.length(); i++){
                    if(sb.charAt(i)!='0') {
                        pointer = i;
                        break;
                    }
                }
                if(sb.substring(pointer).equals("")) n = 0;
                else n = Integer.parseInt(sb.substring(pointer));
            }
            else{
                n--;
            }







            count++;
        }
        System.out.println(count);










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
