import java.util.*;
import java.io.*;

public class Main{
    static int n, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1){
                    list.add(BFS(new Point(i, j)));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for(int size : list){
            sb.append(size).append('\n');
        }
        System.out.println(sb);



    }
    static int BFS(Point curP){
        Queue<Point> queue = new LinkedList<>();
        queue.add(curP);
        arr[curP.i][curP.j] = 2;
        int count = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            count++;
            for(int i=0; i<4; i++){
                int newI = p.i + dx[i];
                int newJ = p.j + dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<n && arr[newI][newJ]==1){
                    queue.add(new Point(newI, newJ));
                    arr[newI][newJ] = 2;
                }
            }
        }
        return count;
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