import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();
        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) queue.add(new Point(i, j, 0));
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int max = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            max = Math.max(max, p.count);
            for(int i = 0; i < 4; i++) {
                int newI = p.x + dx[i];
                int newJ = p.y + dy[i];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || arr[newI][newJ] != 0) continue;
                arr[newI][newJ] = 1;
                queue.add(new Point(newI, newJ, p.count + 1));
            }
        }

        boolean flag = true;
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< m; j++) {
                if (arr[i][j] == 0) {
                    flag = false;
                    continue loop;
                }
            }
        }
        if (!flag) System.out.println(-1);
        else System.out.println(max);
        

    }
    private static class Point {
        int x, y, count;
        private Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
