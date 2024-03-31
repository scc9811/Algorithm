import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        loop:
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(arr[i].charAt(j)=='O') continue loop;
            }
            System.out.println(j+1);
            System.exit(0);
        }

        System.out.println("ESCAPE FAILED");
















    }
}
