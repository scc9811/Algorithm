import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m, arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];



        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
//                    System.out.println("BFS = "+BFS(new Point(i, j)));
                    max = Math.max(max, BFS(new Point(i, j)));
                }
            }
        }
        System.out.println(max);








    }
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int BFS(Point startP){
        Queue<Point> queue = new LinkedList<>();
        queue.add(startP);
        boolean[][] visited = new boolean[n][m];
        visited[startP.x][startP.y] = true;
        int count = 0;
        int tmp = 1;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }

            Point cur = queue.poll();
            for(int i=0; i<8; i++){
                int newI = cur.x + dx[i];
                int newJ = cur.y + dy[i];
                if(newI<n && newI>=0 && newJ<m && newJ>=0 && !visited[newI][newJ]){
                    if(arr[newI][newJ]==1) return count;
                    visited[newI][newJ] = true;
                    queue.add(new Point(newI, newJ));
                }
            }
        }



        return -1;
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}