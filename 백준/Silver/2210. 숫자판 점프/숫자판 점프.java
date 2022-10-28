import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                backTracking(0,i,j);
            }
        }
        System.out.println(set.size());








    }
    static int[] result = new int[6];
    static Set<String> set = new HashSet<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void backTracking(int depth, int startI, int startJ){
        if(depth==6){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++){
                sb.append(result[i]);
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0; i<4; i++){
            int newI = startI+dx[i];
            int newJ = startJ+dy[i];
            if(newI>=0 && newI<5 && newJ>=0 && newJ<5){
                result[depth] = arr[newI][newJ];
                backTracking(depth+1, newI, newJ);
            }
        }








    }
}