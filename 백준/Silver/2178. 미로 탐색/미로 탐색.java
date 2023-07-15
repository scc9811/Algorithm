import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        arr[0][0] = 0;
        int count = 1;
        int tmp = 1;

        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                tmp = queue.size();
                count++;
            }
            Point p = queue.poll();
            for(int i =0; i<4; i++){
                int newI = p.i+dx[i];
                int newJ = p.j+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==1){
                    queue.add(new Point(newI, newJ));
                    if(newI==n-1 && newJ==m-1){
                        System.out.println(count);
                        System.exit(0);
                    }
                    arr[newI][newJ] = 0;
                }
            }
        }






    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
