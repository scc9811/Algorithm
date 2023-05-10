import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

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

        int dayCount = 0;
        while(true){
            arr = next_status();
            dayCount++;
            int areaCount = Count_area();
            if(areaCount==1) continue;
            else if(areaCount==0) {
                System.out.println(0);
                System.exit(0);
            }
            else{
                System.out.println(dayCount);
                System.exit(0);
            }
        }



    }
    static int[][] next_status(){
        int[][] ret = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0) ret[i][j] = 0;
                else {
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int newI = i + dx[k];
                        int newJ = j + dy[k];
                        if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==0) {
                            count++;
                        }
                    }
                    ret[i][j] = Math.max(arr[i][j] - count, 0);
                }
            }
        }
        return ret;
    }
    static int Count_area(){
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]!=0 && !visited[i][j]){
                    count++;
                    BFS(visited, i, j);
                }
            }
        }
        return count;
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void BFS(boolean[][] visited, int startI, int startJ){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startI, startJ));
        visited[startI][startJ] = true;
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.x + dx[i];
                int newJ = curP.y + dy[i];
                if(newI<n && newI>=0 && newJ<m && newJ>=0 && !visited[newI][newJ] && arr[newI][newJ]!=0){
                    queue.add(new Point(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }
        }
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
