import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new char[h][w];
        for(int i=0; i<h; i++){
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());











    }
    static class Point{
        int x, y, count;
        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] costDX = {1,1,0,-1,-1};
    static int[] costDY = {0,-1,-1,-1,0};

    static int[] non_costDX = {-1,0,1};
    static int[] non_costDY = {1,1,1};
    static int bfs(){
//        boolean[][] visited = new boolean[h][w];
        int[][] count = new int[h][w];
        for(int i=0; i<h; i++){
            Arrays.fill(count[i], (int)1e9);
        }

        Point endP = null;
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]=='K') {
                    queue.add(new Point(i, j, 0));
                    count[i][j] = 0;
                }
                else if(board[i][j]=='*'){
                    endP = new Point(i, j, -1);
                }
            }
        }

        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<3; i++){
                int newI = curP.x + non_costDX[i];
                int newJ = curP.y + non_costDY[i];
                if(newI>=0 && newI<h && newJ>=0 && newJ<w && board[newI][newJ]!='#' && count[newI][newJ]>curP.count){
                    queue.add(new Point(newI, newJ, curP.count));
                    count[newI][newJ] = curP.count;
                }
            }
            for(int i=0; i<5; i++){
                int newI = curP.x + costDX[i];
                int newJ = curP.y + costDY[i];
                if(newI>=0 && newI<h && newJ>=0 && newJ<w && board[newI][newJ]!='#' && count[newI][newJ]>curP.count+1){
                    queue.add(new Point(newI, newJ, curP.count+1));
                    count[newI][newJ] = curP.count+1;
                }
            }
        }
        if(count[endP.x][endP.y]==1e9) return -1;
        else return count[endP.x][endP.y];
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
