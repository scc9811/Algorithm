import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s.substring(1,s.length()-1), ",");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int left = 0;
            int right = n;
            boolean tf = true;
            for(int i=0; i<p.length(); i++){
                if(p.charAt(i)=='R'){
                    int tmp = left;
                    left = right;
                    right = tmp;
                }
                else{
                    if(left==right){
                        tf = false;
                        sb.append("error").append('\n');
                        break;
                    }
                    if(left<right) left++;
                    else left--;
                }
            }
            if(!tf) continue;


            sb.append('[');
            if(left<right){
                for(int i=left; i<right; i++){
                    sb.append(arr[i]).append(',');
                }
            }
            else if(left==right){
                sb.append('?');
            }
            else{
                for(int i=left-1; i>=right; i--){
                    sb.append(arr[i]).append(',');
                }
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append(']').append('\n');
        }
        System.out.printf(sb.toString());



    }
}