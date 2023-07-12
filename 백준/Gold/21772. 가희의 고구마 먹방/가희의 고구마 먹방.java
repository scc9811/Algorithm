import java.util.*;
import java.io.*;

public class Main{
    static int n, m, t, res;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        Point startP = null;
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                if(arr[i][j]=='G'){
                    startP = new Point(i, j);
                }
            }
        }
        res = 0;
        DFS(startP, 0, 0);
        System.out.println(res);




    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void DFS(Point p, int depth, int count){
        if(depth==t){
            res = Math.max(res, count);
            return;
        }
        for(int i=0; i<4; i++){
            int newI = p.i+dx[i];
            int newJ = p.j+dy[i];
            if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]!='#'){
                if(arr[newI][newJ]=='S') {
                    arr[newI][newJ] = '.';
                    DFS(new Point(newI, newJ), depth+1, count+1);
                    arr[newI][newJ] = 'S';
                }
                else {
                    DFS(new Point(newI, newJ), depth+1, count);
                }
            }
        }
    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}