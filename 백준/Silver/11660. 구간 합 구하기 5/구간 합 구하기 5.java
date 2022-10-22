import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[][] sumArray = new int[size+1][size+1];
        int testCase = Integer.parseInt(st.nextToken());
        for(int i=1; i<=size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(j==1) sumArray[i][j] = sumArray[i-1][size] + tmp;
                else sumArray[i][j] = sumArray[i][j-1] + tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        int x1, x2, y1, y2;
        while(testCase-->0){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            //
            if(y1==1){
                for(int i=x1; i<=x2; i++){
                    sum += sumArray[i][y2] - sumArray[i-1][size];
                }
            }

            else {
                for(int i=x1; i<=x2; i++){
                    sum += sumArray[i][y2] - sumArray[i][y1-1];
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);










    }
}
