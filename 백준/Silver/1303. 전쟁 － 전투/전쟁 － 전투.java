import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] array = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(s.charAt(j)=='W') array[i][j]=1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int whiteScore = 0;
        int blackScore = 0;
        while(true){
            boolean tf = false;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(array[i][j]==1 && !visited[i][j]){
                        queue.add(i);
                        queue.add(j);
                        visited[i][j]=true;
                        tf = true;
                        break;
                    }
                }
                if(tf) break;
            }
            if(!tf) break;
            int size=1;
            while(!queue.isEmpty()){
                int startI = queue.poll();
                int startJ = queue.poll();
                for(int i=0; i<4; i++){
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if(newI>=0 && newI<m && newJ>=0 && newJ<n && array[newI][newJ]==1 && !visited[newI][newJ]){
                        queue.add(newI);
                        queue.add(newJ);
                        visited[newI][newJ]=true;
                        size++;
                    }
                }
            }

            whiteScore += size*size;
        }

        System.out.printf(whiteScore+" ");

        while(true){
            boolean tf = false;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(array[i][j]==0 && !visited[i][j]){
                        queue.add(i);
                        queue.add(j);
                        visited[i][j]=true;
                        tf = true;
                        break;
                    }
                }
                if(tf) break;
            }
            if(!tf) break;
            int size=1;
            while(!queue.isEmpty()){
                int startI = queue.poll();
                int startJ = queue.poll();
                for(int i=0; i<4; i++){
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if(newI>=0 && newI<m && newJ>=0 && newJ<n && array[newI][newJ]==0 && !visited[newI][newJ]){
                        queue.add(newI);
                        queue.add(newJ);
                        visited[newI][newJ]=true;
                        size++;
                    }
                }
            }

            blackScore += size*size;
        }
        System.out.println(blackScore);

















    }
}
