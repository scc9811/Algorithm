import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int last = 0;
        int count = 1;
        int result = 0;
        boolean isN = true;
        if(s.charAt(0)=='S') isN = false;
        for(int i=1; i<n; i++){
            if(isN){
                if(s.charAt(i)=='S'){
                    isN = false;
                    result = Math.max(result, Math.min(last, count)*2);
                    last = count;
                    count = 1;
                }
                else count++;
            }
            else{
                if(s.charAt(i)=='N'){
                    isN = true;
                    result = Math.max(result, Math.min(last, count)*2);
                    last = count;
                    count = 1;
                }
                else count++;
            }
        }
        result = Math.max(result, Math.min(last, count)*2);
        System.out.println(result);

//        System.out.println(N);
//        System.out.println(S);






    }
}

