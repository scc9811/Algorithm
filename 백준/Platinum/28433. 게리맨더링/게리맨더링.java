import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int plus = 0;
            int minus = 0;
//            System.out.println("n = "+n);
            for(int i=0; i<n; i++){
//                System.out.println("i = "+i);
                int cur = Integer.parseInt(st.nextToken());
                if(cur==0) continue;
                if(cur < 0){
                    if(sum <= 0) sum += cur;
                    else{
                        if(cur + sum > 0){
                            sum += cur;
                        }
                        else {
                            plus++;
                            sum = cur;
                        }
                    }
                }

                else {
                    if(sum > 0){
                        plus++;
                        sum = cur;
                    }
                    else{
                        if(cur + sum > 0) {
                            sum += cur;
                        }
                        else{
                            minus++;
                            sum = cur;
                        }
                    }
                }
//                System.out.println("plus = "+plus);
//                System.out.println("minus = "+minus);
//                System.out.println("cur = "+cur);
//                System.out.println("sum = "+sum);
//                System.out.println();
            }
            if(sum > 0) plus++;
            else if(sum < 0) minus++;
            sb.append(plus > minus ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);







    }
}
