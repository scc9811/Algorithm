import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10010*12];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " -");
            int start = Integer.parseInt(st.nextToken())*12 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())*12 + Integer.parseInt(st.nextToken());
            arr[start]++;
            arr[end+1]--;
        }

        int max = 0;
        int index = -1;
        for(int i=1; i<10010*12; i++){
            arr[i] += arr[i-1];
//            if(arr[i]!=0) {
//                System.out.println("year = "+i/12);
//                System.out.println("month = "+i%12);
//                System.out.println("count = "+arr[i]+'\n');
//
//            }
            if(max<arr[i]){
                max = arr[i];
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        String year;
        String month;

        if(index%12==0) {
            year = String.valueOf(index/12 -1);
            month = "12";
        }
        else{
            year = String.valueOf(index/12);
            if(index%12<10) month = "0" + String.valueOf(index%12);
            else month = String.valueOf(index%12);
        }
        System.out.println(year+"-"+month);





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
