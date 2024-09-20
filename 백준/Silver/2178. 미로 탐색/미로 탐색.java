import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
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
//        boolean[][] visited = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        arr[0][0] = 0;
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }

        int tmp = 1;
        int count = 0;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            Point p = queue.poll();
            int startI = p.x;
            int startJ = p.y;
//            System.out.println("startI = "+startI);
//            System.out.println("startJ = "+startJ);
//            System.out.println();
            for(int i=0; i<4; i++){
                int newI = startI+dx[i];
                int newJ = startJ+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==1){
                    if(newI==n-1 && newJ==m-1){
                        queue = new LinkedList<>();
                        break;
                    }
                    arr[newI][newJ]=0;
                    queue.add(new Point(newI, newJ));
                }
            }
        }
        System.out.println(count+1);





    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}