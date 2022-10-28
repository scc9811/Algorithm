import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] edge = new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edge[start][end] = true;
            edge[end][start] = true;
        }


        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();


        int count = 1;
        boolean tf = false;

        for(int i=1; i<=n; i++) {
            if (edge[x][i]) {
                if(i==y){
                    tf = true;
                    break;
                }
                queue.add(i);
                visited[i] = true;
            }
        }


        if(!tf) {
            count = 2;
            int tmp = queue.size();
            while (!queue.isEmpty()) {
                x = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if (edge[x][i] && !visited[i]) {
                        if (i == y) {
                            tf = true;
                            break;
                        }
                        queue.add(i);
                        visited[i] = true;
                    }
                }
                if (tf) break;
                tmp--;
                if (tmp == 0) {
                    count++;
                    tmp = queue.size();
                }
            }
        }
        if(tf) System.out.println(count);
        else System.out.println(-1);












    }
}
