import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            for (int i = 0; i < l; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            Queue<Point> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                        queue.add(new Point(i, j));
                        arr[i][j] = 0;
                        while (!queue.isEmpty()) {
                            Point curP = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int newI = curP.i + dx[k];
                                int newJ = curP.j + dy[k];
                                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && arr[newI][newJ] == 1) {
                                    queue.add(new Point(newI, newJ));
                                    arr[newI][newJ] = 0;
                                }
                            }
                        }
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);






    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}


