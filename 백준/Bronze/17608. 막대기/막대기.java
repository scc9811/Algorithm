import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        int k = array[n-1];
        int count=1;

        for(int i=n-2; i>=0; i--){
            if(k<array[i]){
                count++;
                k = array[i];
            }
        }

        System.out.println(count);







    }
}