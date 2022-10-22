import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=1;
        int count=1;
        int step=1;
        while(n>sum){
            step++;
            sum +=step;
            count++;
        }

        n = n-(sum-step);
        // 짝수면 1/x부터
        if(count%2==0){
            System.out.printf("%d/%d",n,count-n+1);

        }
        // 홀수면 x/1부터
        else{
            System.out.printf("%d/%d",count-n+1,n);
        }








    }
}