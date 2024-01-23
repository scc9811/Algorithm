import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, m, d[], arr[][];
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n+1][1001];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for(int j=1; j<=d[i]; j++){
                priorityQueue.add(Integer.parseInt(st.nextToken()));
//                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j=1; j<=d[i]; j++){
                arr[i][j] = priorityQueue.poll();
            }
        }

        dp = new boolean [n+1][m+1];
        boolean exitFlag = true;
        for(int k=1; k<=d[1]; k++){
            int curTime = arr[1][k];
            for(int j=m; j>=curTime+1; j--){
                if(dp[1][j-curTime]){
                    dp[1][j] = true;
                }
            }
            if(curTime <= m){
                exitFlag = false;
                dp[1][curTime] = true;
            }
        }


        if(exitFlag){
            System.out.println(-1);
            System.exit(0);
        }
//        printFunction();

        for(int i=2; i<=n; i++){
            exitFlag = true;
            for(int k=1; k<=d[i]; k++){
                int curTime = arr[i][k];
                for(int j=m; j>=curTime+1; j--){
                    if(dp[i-1][j-curTime]){
                        dp[i][j] = true;
                        exitFlag = false;
                    }
                    if(dp[i][j-curTime]){
                        dp[i][j] = true;
                    }
                }
            }
            if(exitFlag){
//                printFunction();
                System.out.println(-1);
                System.exit(0);
            }
        }
//        printFunction();
        int res = -1;
        for(int j=1; j<=m; j++){
            if(dp[n][j]){
                res = j;
            }
        }

        System.out.println(res);

















    }
    static void printFunction(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            System.out.println(Arrays.toString(dp[i]));
            for(int j=1; j<=m; j++){
                if(dp[i][j]) sb.append(j).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}