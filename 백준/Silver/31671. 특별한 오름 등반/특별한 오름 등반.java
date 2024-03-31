import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[2*n+1][2*n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            visited[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        int res = -1;

        while(!queue.isEmpty()){
            Point curP = queue.poll();
            if(isValidPoint(curP.x+1, curP.y+1) && !visited[curP.x+1][curP.y+1]){
                visited[curP.x+1][curP.y+1] = true;
                queue.add(new Point(Math.max(curP.maxHeight, curP.y+1), curP.x+1, curP.y+1));
            }
            if(isValidPoint(curP.x+1, curP.y-1) && !visited[curP.x+1][curP.y-1]){
                if(curP.x+1==2*n && curP.y-1 == 0) {
                    res = Math.max(res, curP.maxHeight);
                    continue;
                }
                visited[curP.x+1][curP.y-1] = true;
                queue.add(new Point(curP.maxHeight, curP.x+1, curP.y-1));
            }
        }

        System.out.println(res);
















    }
    static boolean isValidPoint(int x, int y){
        if(x > 2*n || y < 0) return false;
        if(x==n){
            if(y<=n) return true;
            return false;
        }
        else if(x < n){
            if(y <= x) return true;
            return false;
        }
        else{
            if(y <= 2*n-x) return true;
            return false;
        }
    }
    static class Point{
        int maxHeight, x, y;
        Point(int maxHeight, int x, int y){
            this.maxHeight = maxHeight;
            this.x = x;
            this.y = y;
        }
    }
}
