import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int twoCount=0;
        int fiveCount=0;

        for (int i=1; i<=n; i++){
            int k=i;
            while(k%2==0){
                twoCount++;
                k /=2;
            }
            while(k%5==0){
                fiveCount++;
                k /=5;
            }
            array[i] = Math.min(twoCount,fiveCount);
        }
        System.out.println(array[n]);

    }

}
