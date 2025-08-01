import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegTree segTree = new SegTree(n);
        segTree.init(arr, 1, 1, n);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (flag == 1) {
                segTree.update(1, 1, n, b, c - arr[b]);
                arr[b] = c;
            }
            else {
                sb.append(segTree.sum(1, 1, n, b, (int) c));
                sb.append('\n');
            }
        }

        System.out.println(sb);
        






    }
    static class SegTree {
        long[] tree;

        SegTree(int n) {
            double h = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            int nodeCount = (int) Math.round(Math.pow(2, h));
            tree = new long[nodeCount];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
            return tree[node] = init(arr, node*2, start, (start+end)/2) +
                    init(arr, node*2+1, (start+end)/2+1, end);
        }

        long sum(int node, int start, int end, int left, int right) {
            if (end < left || right < start) return 0;
            else if (left <= start && end <= right) return tree[node];
            else return sum(node * 2, start, (start + end) / 2, left, right) +
                        sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

        void update(int node, int start, int end, int index, long diff) {
            if (index < start || end < index) return;
            tree[node] = tree[node] + diff;
            if (start != end) {
                update(node*2, start, (start+end)/2, index, diff);
                update(node*2+1, (start+end)/2+1, end, index, diff);
            }

        }
    }
}
