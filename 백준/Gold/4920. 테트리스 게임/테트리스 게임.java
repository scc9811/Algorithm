import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            n = Integer.parseInt(br.readLine().split(" ")[0]);
            if (n == 0) break;
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(testCase++).append('.').append(' ').append(s()).append('\n');

        }
        System.out.println(sb);
    }
    public static int s(){
        int max = (int)-1e9;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int st = arr[i][j];
                // 1. (가로 4개)
                if(j+3<n) max = Math.max(max, st+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
                // 2. (세로 4개)
                if(i+3<n) max = Math.max(max, st+arr[i+1][j]+arr[i+2][j]+arr[i+3][j]);
                // 3. z
                if(i+1<n && j+2<n) max = Math.max(max, st+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2]);
                // 4. z 90도 회전
                if(i+2<n && j-1>=0) max = Math.max(max, st+arr[i+1][j-1]+arr[i+1][j]+arr[i+2][j-1]);
                // 5. ㄱ
                if(i+1<n && j+2<n) max = Math.max(max, st+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2]);
                // 6. ㄱ 90도 회전 
                if(i+2<n && j-1>=0) max = Math.max(max, st+arr[i+1][j]+arr[i+2][j]+arr[i+2][j-1]);
                // 7. ㄱ 180도 회전
                if(i+1<n && j+2<n) max = Math.max(max, st+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]);
                // 8. ㄱ 270 회전
                if(i+2<n && j+1<n) max = Math.max(max, st+arr[i][j+1]+arr[i+1][j]+arr[i+2][j]);
                // 9. ㅜ
                if(i+1<n && j+2<n) max = Math.max(max, st+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]);
                // 10. ㅓ
                if(i+2<n && j-1>=0) max = Math.max(max, st+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j]);
                // 11. ㅗ
                if(i-1>=0 && j+2<n) max = Math.max(max, st+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+1]);
                // 12. ㅏ
                if(i+2<n && j+1<n) max = Math.max(max, st+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j]);
                // 13. ㅁ
                if(i+1<n && j+1<n) max = Math.max(max, st+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]);
            }
        }
        return max;
    }
}