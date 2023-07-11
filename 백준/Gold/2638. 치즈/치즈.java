import java.io.*;
import java.util.*;
public class Main{
    static int n, m, arr[][];
    static Set<Point> out_of_boundary;
    public static void main(String[] args) throws IOException {
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

        out_of_boundary = new LinkedHashSet<>();
        int count = 0;
        while(set_status()){
            count++;
        }
        System.out.println(count);






    }
    static boolean set_status(){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Point(0, 0));
        out_of_boundary.clear();
        out_of_boundary.add(new Point(0, 0));
        while(!queue.isEmpty()){
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.i + dx[i];
                int newJ = curP.j + dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ] && arr[newI][newJ]==0){
                    queue.add(new Point(newI, newJ));
                    out_of_boundary.add(new Point(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }
        }
        int flag = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int newI = i+dx[k];
                        int newJ = j+dy[k];
                        if(newI>=0 && newI<n && newJ>=0 && newJ<m && out_of_boundary.contains(new Point(newI, newJ))) count++;
                    }
                    if(count>=2){
                        arr[i][j] = 0;
                        flag = 1;
                    }
                }
            }
        }
        return flag == 1;
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
        public int hashCode() {
            return this.i*1000 + this.j;
        }
        public boolean equals(Object o){
            Point p = (Point) o;
            return this.hashCode() == p.hashCode();
        }
    }


}
