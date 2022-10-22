import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n==0) break;
            int count = 0;
            for (int i=n+1; i<=2*n; i++){
                boolean tf = true;
                for (int j=2; j*j<=i; j++){
                    if(i%j==0) {
                        tf = false;
                        break;
                    }
                }
                if (tf) count++;
            }
            System.out.println(count);




        }








    }
}
