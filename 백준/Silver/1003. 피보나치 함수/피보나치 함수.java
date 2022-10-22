import java.io.*;
import java.util.*;


public class Main {
    static int[] dp_zero = new int[41];
    static int[] dp_one = new int[41];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp_zero[0] = 1;
        dp_zero[1] = 0;
        dp_one[0] = 0;
        dp_one[1] = 1;
        for (int i=2; i<41; i++){
            dp_zero[i] = dp_zero[i-1]+dp_zero[i-2];
            dp_one[i] = dp_one[i-1]+dp_one[i-2];
        }
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp_zero[n]).append(" ").append(dp_one[n]).append("\n");

        }
        sb.delete(sb.length()-1,sb.length());
        bw.write(sb.toString());
        bw.close();








    }

}
