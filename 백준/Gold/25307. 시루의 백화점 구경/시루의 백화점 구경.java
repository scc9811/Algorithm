import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m, k, arr[][], newBoard[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        // -1 : ok, else : no.
        newBoard = new int[n][m];
        Queue<Mannequin> queue = new LinkedList<>();

        Point startP = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(newBoard[i], -1);
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==3) {
                    queue.add(new Mannequin(i, j, k));
                    newBoard[i][j] = k;
                }
                else if(arr[i][j]==1) newBoard[i][j] = 0;
                else if(arr[i][j]==4) startP = new Point(i, j, 0);
            }
        }

        while(!queue.isEmpty()){
            Mannequin curM = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curM.i+dx[i];
                int newJ = curM.j+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && newBoard[newI][newJ]<curM.c-1){
                    newBoard[newI][newJ] = curM.c-1;
                    if(curM.c-1==0) continue;
                    queue.add(new Mannequin(newI, newJ, curM.c-1));
                }
            }
        }


        if(newBoard[startP.i][startP.j]>0) {
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(BFS(startP));










    }
    static int BFS(Point startP){
        Queue<Point> queue = new LinkedList<>();
        queue.add(startP);
        boolean[][] visited = new boolean[n][m];
        visited[startP.i][startP.j] = true;
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.i + dx[i];
                int newJ = curP.j + dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ] && newBoard[newI][newJ]==-1){
                    if(arr[newI][newJ]==2) return curP.count+1;
                    visited[newI][newJ] = true;
                    queue.add(new Point(newI, newJ, curP.count+1));
                }
            }
        }
        return -1;
    }
    static class Point{
        int i, j, count;
        Point(int i, int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
    static class Mannequin{
        int i, j, c;
        Mannequin(int i, int j, int c){
            this.i = i;
            this.j = j;
            this.c = c;
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
