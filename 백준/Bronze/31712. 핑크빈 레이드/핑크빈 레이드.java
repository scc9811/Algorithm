import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cu = Integer.parseInt(st.nextToken());
        int du = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cd = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cp = Integer.parseInt(st.nextToken());
        int dp = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(br.readLine());

        h -= du + dd + dp;
        if(h <= 0){
            System.out.println(0);
            System.exit(0);
        }
        for(int i=1; i<=5000; i++){
            if(i % cu == 0) h -= du;
            if(i % cd == 0) h -= dd;
            if(i % cp == 0) h -= dp;

            if(h <= 0) {
                System.out.println(i);
                System.exit(0);
            }
        }
















    }
}
