import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-->0){
            String s = br.readLine();
            int left = 0;
            int right = 0;
            boolean flag = false;
            int k = -1;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) != '!'){
                    k = s.charAt(i)-'0';
                    flag = true;
                }
                else {
                    if(!flag) left++;
                    else right++;
                }
            }

            if(right!=0) k = 1;

            if(k==0){
                if(left%2==0) sb.append(0);
                else sb.append(1);
            }
            else{
                if(left%2==0) sb.append(1);
                else sb.append(0);
            }
            sb.append('\n');






        }
        System.out.println(sb);















    }
}