import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static char[][] board;
    static int res;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        res = (int) 1e9;
        for(int i=0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                check(i, j);
            }
        }
        System.out.println(res);









    }
    public static void check(int startI, int startJ){
        int count = 0;
        for(int i=startI; i<startI+8; i+=2){
            for(int j=startJ; j<startJ+8; j+=2){
                if(board[i][j]=='B') count++;
            }
            for(int j=startJ+1; j<startJ+8; j+=2){
                if(board[i][j]=='W') count++;
            }
        }
        for(int i=startI+1; i<startI+8; i+=2){
            for(int j=startJ; j<startJ+8; j+=2){
                if(board[i][j]=='W') count++;
            }
            for(int j=startJ+1; j<startJ+8; j+=2){
                if(board[i][j]=='B') count++;
            }
        }
        count = Math.min(count, 64-count);
        res = Math.min(res, count);







    }
}