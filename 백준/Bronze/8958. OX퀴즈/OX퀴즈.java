import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-->0){
            String s = br.readLine();
            int sum=0;
            int score=0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='O'){
                    sum += ++score;
                    continue;
                }
                score=0;
            }
            bw.write(String.valueOf(sum));
            bw.write('\n');
        }
        bw.close();











    }

}
