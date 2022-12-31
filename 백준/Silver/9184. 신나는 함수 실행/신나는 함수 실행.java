import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new int[51][51][51];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1) break;

            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
        }
        





    }
    static int[][][] memo;
    public static int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return w(20, 20, 20);
        if(memo[a][b][c]!=0) return memo[a][b][c];
        if(a<b && b<c){
            memo[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
            return memo[a][b][c];
        }
        memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return memo[a][b][c];
    }
}