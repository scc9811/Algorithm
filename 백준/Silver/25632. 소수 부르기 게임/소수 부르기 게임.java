import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=1000; i++){
            boolean flag = true;
            for(int j=2; j*j<=i; j++){
                if(i%j==0) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(i);
        }


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i : list){
            if(i>=a && i<=b) list1.add(i);
            if(i>=c && i<=d) list2.add(i);
        }

        int k = 0;
        for(int i : list1){
            if(list2.contains(i)) k++;
        }

        a = list1.size();
        b = list2.size();

        if(k==0){
            if(a<=b) System.out.println("yj");
            else System.out.println("yt");
        }
        else{
            if(k%2==0){
                if(a<=b) System.out.println("yj");
                else System.out.println("yt");
            }
            else{
                if(a>=b) System.out.println("yt");
                else System.out.println("yj");
            }
        }






    }
    static class Node implements Comparable<Node>{
        int from, to, weight;
        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
        }
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
