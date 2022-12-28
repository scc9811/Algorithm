import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, arr[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 0 : false, 1 : true
        visited = new boolean[n][m][2];
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        
        if(n==1 && m==1) System.out.println(1);
        else System.out.println(BFS());







    }
    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, false));
        int count=1;
        int tmp=1;
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
                    // 이미 벽을 부순 Point 인 경우.
                    if(p.alreadyBroken){
                        if(arr[newI][newJ]==0 && !visited[newI][newJ][1]){
                            visited[newI][newJ][1] = true;
                            queue.add(new Point(newI, newJ, true));
                        }
                    }
                    // 벽을 아직 부수지 않은 Point 인 경우.
                    else{
                        if(arr[newI][newJ]==0 && !visited[newI][newJ][0]){
                            visited[newI][newJ][0] = true;
                            queue.add(new Point(newI, newJ, false));
                        }
                        if(arr[newI][newJ]==1 && !visited[newI][newJ][1]){
                            visited[newI][newJ][1] = true;
                            queue.add(new Point(newI, newJ, true));
                        }
                    }
                }
            }




        }



        return -1;
    }
    public static class Point{
        int x, y;
        boolean alreadyBroken;
        Point(int x, int y, boolean alreadyBroken){
            this.x = x;
            this.y = y;
            this.alreadyBroken = alreadyBroken;
        }
    }
}
