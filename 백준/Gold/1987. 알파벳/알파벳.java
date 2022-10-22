import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r,c,max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] array;
    static boolean[] alphabetArray = new boolean[26];
    static boolean[][] tfArray;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        array = new int[r][c];
        tfArray = new boolean[r][c];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                array[i][j] = s.charAt(j)-65;
            }
        }
        max = 0;
        tfArray[0][0]=true;
        alphabetArray[array[0][0]]=true;
        backTracking(1,0,0);
        System.out.println(max);



    }
    public static void backTracking(int count, int startI, int startJ){
        int tmp=0;
        for(int i=0; i<4; i++){
            int newI = startI+dx[i];
            int newJ = startJ+dy[i];
            if(newI>=0 && newI<r && newJ>=0 && newJ<c){
                if(tfArray[newI][newJ] || alphabetArray[array[newI][newJ]]) continue;
                tfArray[newI][newJ]=true;
                alphabetArray[array[newI][newJ]]=true;
                backTracking(count+1,newI,newJ);
                tfArray[newI][newJ]=false;
                alphabetArray[array[newI][newJ]]=false;
                tmp++;
            }
        }
        if(tmp==0){
            max = Math.max(max,count);
            return;
        }


    }
}
