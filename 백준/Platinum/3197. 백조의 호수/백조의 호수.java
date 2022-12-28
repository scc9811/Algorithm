import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static Point beak1 = null, beak2 = null;
    static Queue<Point> queue = new LinkedList<>();
    static Set<Point> next = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j]=='L'){
                    if(beak1==null) {
                        beak1 = new Point(i,j);
                    }
                    else beak2 = new Point(i, j);
                    arr[i][j] = '.';
                }
            }
        }



        meltVisited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=='.'){
                    for(int k=0; k<4; k++){
                        int newI = i+dx[k];
                        int newJ = j+dy[k];
                        if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]=='X' && !meltVisited[newI][newJ]){
                            next.add(new Point(newI, newJ));
                            meltVisited[newI][newJ] = true;
                        }
                    }
                }
            }
        }





        System.out.println(solve());







    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static int solve(){
        int count = 0;
        queue.add(beak1);
        visited[beak1.x][beak1.y] = true;
        lastPoints = new LinkedList<>();
        while(!queue.isEmpty()){
            Point p = queue.poll();
            boolean isLastPoint = false;
            for(int i=0; i<4; i++){
                int newI = p.x+dx[i];
                int newJ = p.y+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ]){
                    if(arr[newI][newJ]=='X') isLastPoint = true;
                    else {
                        if (newI == beak2.x && newJ == beak2.y) return count;
                        visited[newI][newJ] = true;
                        queue.add(new Point(newI, newJ));
                    }
                }
            }
            if(isLastPoint){
                lastPoints.add(p);
            }
        }



        while(true) {
            melt();
            count++;
            if(isCanMeet()) return count;
        }
    }
    static Queue<Point> lastPoints;
    public static boolean isCanMeet(){
        Queue<Point> nextPoints = new LinkedList<>();
        while(!lastPoints.isEmpty()) {
            Point p = lastPoints.poll();
            boolean isLastPoint = false;
            for (int i = 0; i < 4; i++) {
                int newI = p.x+dx[i];
                int newJ = p.y+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ]){
                    if(arr[newI][newJ]=='X') isLastPoint = true;
                    else {
                        if (newI == beak2.x && newJ == beak2.y) return true;
                        visited[newI][newJ] = true;
                        lastPoints.add(new Point(newI, newJ));
                    }
                }
            }
            if(isLastPoint) nextPoints.add(p);
        }
        lastPoints = nextPoints;
        return false;
    }

    static boolean[][] meltVisited;
    public static void melt(){
        Object[] now = next.toArray();
        next = new HashSet<>();
        for (Object o : now) {
            Point p = (Point) o;
            arr[p.x][p.y] = '.';
            for (int j = 0; j < 4; j++) {
                int newI = p.x + dx[j];
                int newJ = p.y + dy[j];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && arr[newI][newJ] == 'X' && !meltVisited[newI][newJ]) {
                    Point newP = new Point(newI, newJ);
                    meltVisited[newI][newJ] = true;
                    next.add(newP);
                }
            }
        }

    }

    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
    }
}