import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n,m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        virusI = new int[m];
        virusJ = new int[m];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0,0);
        if(minimumDays==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minimumDays);









    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
// boolean[][] bfs_visited = new boolean[n][n];
        int[][] copy = new int[n][n];
        for(int i=0; i<n; i++){
            copy[i] = arr[i].clone();
        }



        for(int i=0; i<m; i++){
            queue.add(virusI[i]);
            queue.add(virusJ[i]);
            copy[virusI[i]][virusJ[i]] = -1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(copy[i][j]==2) copy[i][j] = 0;
            }
        }


//        System.out.println("virusI");
//        System.out.println(Arrays.toString(virusI));
//        System.out.println("virusJ");
//        System.out.println(Arrays.toString(virusJ));
//        System.out.println();

        int days = 0;
        int tmp = queue.size()/2;
        while(!queue.isEmpty()){
            int startI = queue.poll();
            int startJ = queue.poll();
            for(int i=0; i<4; i++){
                int newI = startI+dx[i];
                int newJ = startJ+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<n && copy[newI][newJ]==0){
                    queue.add(newI);
                    queue.add(newJ);
                    copy[newI][newJ] = days+1;
                }
            }
            tmp--;
            if(!queue.isEmpty() && tmp==0){
                days++;
                tmp = queue.size()/2;
            }
        }


        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(copy[i][j]==0){
                    return Integer.MAX_VALUE;
                }
                if(arr[i][j]==2 || arr[i][j]==1) continue;
                result = Math.max(result, copy[i][j]);
            }
        }

//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(copy[i]));
//        }


        return result;

    }
    static int minimumDays = Integer.MAX_VALUE;
    static int[] virusI, virusJ;
    static boolean[][] visited;
    public static void backTracking(int depth, int startI, int startJ){
        if(depth==m){
            minimumDays = Math.min(minimumDays, BFS());
            return;
        }


        for(int j=startJ; j<n; j++){
            if(arr[startI][j]==2){
                visited[startI][j] = true;
                virusI[depth] = startI;
                virusJ[depth] = j;
                backTracking(depth+1, startI, j+1);
            }
        }

        for(int i=startI+1; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==2){
                    visited[i][j] = true;
                    virusI[depth] = i;
                    virusJ[depth] = j;
                    backTracking(depth+1, i, j+1);
                }
            }
        }




    }
}