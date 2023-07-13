import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int res;
            if(x1==x2 && y1==y2){
                if(r1==r2){
                    res = -1;
                }
                else res = 0;
            }
            else {
                double p_p = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
                if(r1 < r2){
                    int tmp = r1;
                    r1 = r2;
                    r2 = tmp;
                }
                // r1 >= r2
                if(p_p + r2 == r1){
                    res = 1;
                }
                else if(p_p + r2 < r1){
                    res = 0;
                }
                else {
                    if(p_p - r2 > r1){
                        res = 0;
                    }
                    else if(p_p - r2 == r1){
                        res = 1;
                    }
                    else{
                        res = 2;
                    }
                }
            }

            sb.append(res).append('\n');
        }
        System.out.println(sb);


    }
}


