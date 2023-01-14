import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        // 0 : sk, 1 : cy
        arr[1] = 0;
        if(n>1) arr[2] = 1;
        if(n>2) arr[3] = 0;
        for(int i=4; i<=n; i++){
            arr[i] = (arr[i-1]+1)%2;
        }
        if(arr[n]==0) System.out.println("SK");
        else System.out.println("CY");







    }
}