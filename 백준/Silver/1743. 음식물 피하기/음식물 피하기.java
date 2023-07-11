import java.io.*;
import java.util.*;
public class Main{
    static int n, m, arr[][], res;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        visited = new boolean[n+1][m+1];
        res = -1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    BFS(new Point(i, j));
                }
            }
        }
        System.out.println(res);


    }
    static void BFS(Point startP){
        Queue<Point> queue = new LinkedList<>();
        queue.add(startP);
        int count = 1;
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.i + dx[i];
                int newJ = curP.j + dy[i];
                if(newI>0 && newI<=n && newJ>0 && newJ<=m && arr[newI][newJ]==1 && !visited[newI][newJ]){
                    count++;
                    queue.add(new Point(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }
        }
        res = Math.max(res, count);
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
