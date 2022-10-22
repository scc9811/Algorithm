import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int startI = Integer.parseInt(st.nextToken());
        int startJ = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        array[startI][startJ]=2;
        int count=1;

        while(true){
            direction = (direction+3)%4;
            int newI,newJ;
            boolean tf = false;
            for(int i=0; i<4; i++){
                newI = startI+dx[direction];
                newJ = startJ+dy[direction];
                if(newI<n && newI>=0 && newJ<m && newJ>=0 && array[newI][newJ]==0){
                    startI = newI;
                    startJ = newJ;
                    array[newI][newJ]=2;
                    count++;
                    tf = true;
                    break;
                }
                if(i<3) direction = (direction+3)%4;
            }
            if(tf) continue;

            // 후진 or 종료

            newI = startI+dx[(direction+2)%4];
            newJ = startJ+dy[(direction+2)%4];
            if(newI<n && newI>=0 && newJ<m && newJ>=0 && array[newI][newJ]==2){
                startI = newI;
                startJ = newJ;
                continue;
            }
            break;
        }
        System.out.println(count);
        










    }
}