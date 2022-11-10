import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n, m, arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Queue<Point>  queue = new LinkedList<>();
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) queue.add(new Point(i, j));
            }
        }



        int days = 0;
        int tmp = queue.size();
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int startI = p.x;
            int startJ = p.y;
            for(int i=0; i<4; i++){
                int newI = startI+dx[i];
                int newJ = startJ+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==0){
                    arr[newI][newJ] = 1;
                    queue.add(new Point(newI, newJ));
                }
            }

            tmp--;
            if(tmp==0){
                days++;
                tmp = queue.size();
            }
        }
        days--;

        if(TF()) System.out.println(days);
        else System.out.println(-1);





    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean TF(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0) return false;
            }
        }

        return true;
    }

}
