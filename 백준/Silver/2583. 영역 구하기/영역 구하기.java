import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int j=ly; j<ry; j++){
                Arrays.fill(arr[j], lx, rx, true);
            }
        }


        BFS();
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for(int i=0; i<result.size(); i++){
            sb.append(result.get(i)).append(' ');
        }
        System.out.println(sb);







    }
    static List<Integer> result = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void BFS(){
        while(true){
            Point start = check();
            if(start==null) break;
            Queue<Point> queue = new LinkedList<>();
            queue.add(start);
            arr[start.x][start.y] = true;
            int count = 1;
            while(!queue.isEmpty()){
                Point p = queue.poll();
                int startI = p.x;
                int startJ = p.y;
                for(int i=0; i<4; i++){
                    int newI = startI+dx[i];
                    int newJ = startJ+dy[i];
                    if(newI>=0 && newI<n && newJ>=0 && newJ<m && !arr[newI][newJ]){
                        count++;
                        arr[newI][newJ]=true;
                        queue.add(new Point(newI, newJ));
                    }
                }
            }
            result.add(count);
        }
    }

    public static Point check(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!arr[i][j]){
                    return new Point(i, j);
                }
            }
        }
        return null;
    }


    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}