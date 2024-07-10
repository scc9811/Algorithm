import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        int resCount = 0;
        StringBuilder sb = new StringBuilder();
        loop:
        for(int i=0; i<n; i++) {
            if(arr[i][1].equals("-")) continue;
            int count = 0;
            for(int j=0; j<i; j++) {
                if(arr[i][1].equals(arr[j][1])) continue loop;
            }
            int idx = -1;
            for(int j=i+1; j<n; j++) {
                if(arr[j][1].equals(arr[i][1])) {
                    count++;
                    idx = j;
                }
            }
            if(count == 1) {
                resCount++;
                sb.append(arr[i][0]).append(' ').append(arr[idx][0]).append('\n');
            }
        }
        System.out.println(resCount);
        System.out.println(sb);






    }
}