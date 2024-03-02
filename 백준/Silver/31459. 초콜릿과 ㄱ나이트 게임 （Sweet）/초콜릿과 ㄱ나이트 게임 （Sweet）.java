import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int newI = i-x;
                    int newJ = j-y;
                    if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==1){}
                    else {
                        count++;
                        arr[i][j] = 1;
                    }
                }
            }

            sb.append(count).append('\n');












        }
        System.out.println(sb);
















    }
}