import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m, arr[][], area[][], counts[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        area = new int[n][m];
        counts = new int[n][m];

        fill_area();

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    int sum = 1;
                    Set<Integer> set = new LinkedHashSet<>();
                    for(int k=0; k<4; k++){
                        int newI = i+dx[k];
                        int newJ = j+dy[k];
                        if(newI>=0 && newI<n && newJ>=0 && newJ<m && !set.contains(area[newI][newJ])){
                            sum += counts[newI][newJ];
                            set.add(area[newI][newJ]);
                        }
                    }
                    sb.append(sum%10);
                }
                else sb.append(0);
            }
            System.out.println(sb);
        }









    }
    static void fill_area(){
        boolean[][] visited = new boolean[n][m];
        int nameCount = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && arr[i][j]!=1) {
                    Queue<Point> queue = new LinkedList<>();
                    List<Point> list = new ArrayList<>();
                    visited[i][j] = true;
                    list.add(new Point(i, j));
                    queue.add(new Point(i, j));
                    int count = 1;
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int k=0; k<4; k++){
                            int newI = p.i+dx[k];
                            int newJ = p.j+dy[k];
                            if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ] && arr[newI][newJ]!=1){
                                visited[newI][newJ] = true;
                                queue.add(new Point(newI, newJ));
                                list.add(new Point(newI, newJ));
                                count++;
                            }
                        }
                    }

                    for(Point p : list){
                        counts[p.i][p.j] = count;
                        area[p.i][p.j] = nameCount;
                    }
                    nameCount++;
                }

            }
        }



    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
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
