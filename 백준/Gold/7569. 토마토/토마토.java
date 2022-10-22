import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int n,m,h;
    static int[][][] array;
    public static void main(String[] args)throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        array = new int[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    array[i][j][k] = Integer.parseInt(st.nextToken());
                    if(array[i][j][k]==1){
                        queue.add(i);
                        queue.add(j);
                        queue.add(k);
                    }
                }
            }
        }

//        for(int i=0; i<h; i++){
//            for(int j=0; j<n; j++){
//                System.out.println(Arrays.toString(array[i][j]));
//            }
//        }

        int days=0;
        int count=queue.size()/3;
        while(!queue.isEmpty()){
            int startI=queue.poll();
            int startJ=queue.poll();
            int startK=queue.poll();
            count--;
            for(int i=0; i<6; i++){
                int newI=startI+dx[i];
                int newJ=startJ+dy[i];
                int newK=startK+dz[i];
                if(newI<h && newI>=0 && newJ<n && newJ>=0 && newK<m && newK>=0
                        && array[newI][newJ][newK]==0){
                    queue.add(newI);
                    queue.add(newJ);
                    queue.add(newK);
                    array[newI][newJ][newK]=1;
                }
            }

            if(count==0){
                days++;
                count=queue.size()/3;
            }
        }

        boolean tf = true;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(array[i][j][k]==0){
                        tf=false;
                        break;
                    }
                }
                if(!tf) break;
            }
            if(!tf) break;
        }

        if(tf) System.out.println(days-1);
        if(!tf) System.out.println(-1);









    }
}
