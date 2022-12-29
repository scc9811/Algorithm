import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, arr[][];
    static boolean visited[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m][k+1];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        if(n==1 && m==1) System.out.println(1);
        else System.out.println(BFS());





    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true;
        int count = 1;
        int tmp = 1;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                tmp = queue.size();
                count++;
            }
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int newI = p.x+dx[i];
                int newJ = p.y+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m){
                    if(newI==n-1 && newJ==m-1) return count;
                    if(arr[newI][newJ]==0 && !visited[newI][newJ][p.broken]){
                        visited[newI][newJ][p.broken] = true;
                        queue.add(new Point(newI, newJ, p.broken));
                    }
                    else if(arr[newI][newJ]==1 && p.broken<k && !visited[newI][newJ][p.broken+1]){
                        visited[newI][newJ][p.broken+1] = true;
                        queue.add(new Point(newI, newJ, p.broken+1));
                    }
                }
            }




        }
        return -1;
    }
    public static class Point{
        int x, y, broken;
        Point(int x, int y, int broken){
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}