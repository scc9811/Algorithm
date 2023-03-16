import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int count = 0;
        while(n!=1){
            n /= 2;
            count++;
        }

        int tmp = 1;
        int kCount = 0;
        while(tmp<=k){
            tmp *= 2;
            kCount++;
        }
        kCount--;
        

        if(count<kCount + m){
            System.out.println(count);
        }
        else System.out.println(kCount+m);










    }
}