import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        int sum=0;
        if(start==1) start=2;
        for(int i=start; i<=end; i++){
            boolean tf = true;
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    tf=false;
                    break;
                }
            }
            if(tf){
                if(sb.length()==1) sb.append(i);
                sum +=i;
            }
        }

        if(sum==0) System.out.println(-1);
        else {
            sb.insert(0, sum);
            System.out.println(sb);
        }




    }
}