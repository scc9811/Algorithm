import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy1 = {0, 1, 1, 1, 0, -1};
    static int[] dy2 = {-1, 0, 1, 0, -1, -1};
    static int n, m, k;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            visited[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        System.out.println(BFS());









    }
    static int BFS(){
        if(visited[0][0]) return -1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        int count = 0;
        int tmp = 1;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            Point curP = queue.poll();
//            System.out.printf("(%d, %d)\n", curP.x, curP.y);
            for(int i=0; i<6; i++){
                int newI = curP.x + dx[i];
                int newJ;
                if(curP.x%2==0) newJ = curP.y + dy2[i];
                else newJ = curP.y + dy1[i];

                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ]){
                    visited[newI][newJ] = true;
                    queue.add(new Point(newI, newJ));
                    if(newI==n-1 && newJ==m-1) return count;
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