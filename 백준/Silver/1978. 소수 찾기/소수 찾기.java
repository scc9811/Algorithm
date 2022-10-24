import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count=0;
        while(n-->0){
            int k=Integer.parseInt(st.nextToken());
            boolean tf = true;
            for (int i=2; i*i<=k; i++){
                if(k%i==0) {
                    tf=false;
                    break;
                }
            }
            if (tf) count++;
            if (k==1) count--;
        }
        System.out.println(count);



    }
}
