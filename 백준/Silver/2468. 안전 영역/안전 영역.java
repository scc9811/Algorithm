import java.io.*;
import java.util.*;
public class Main{
    static int n, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 1;
        for(int height=1; height<=100; height++){
            res = Math.max(res, bfs(height));
        }

        System.out.println(res);






    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int bfs(int height){
        boolean[][] visited = new boolean[n][n];
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] > height && !visited[i][j]){
                    count++;
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        Point curP = queue.poll();
                        for(int k=0; k<4; k++){
                            int newI = curP.i + dx[k];
                            int newJ = curP.j + dy[k];
                            if(newI>=0 && newI<n && newJ>=0 && newJ<n && !visited[newI][newJ] && arr[newI][newJ] > height){
                                queue.add(new Point(newI, newJ));
                                visited[newI][newJ] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
