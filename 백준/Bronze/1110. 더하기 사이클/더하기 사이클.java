import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k;
        if (n<10) k = n*10 +n;
        else k = ((n/10+n%10)%10)+n%10*10;
        int count=1;

        while (k!=n){
            if(k<10) k = k*10+k;
            else k = ((k/10+k%10)%10)+k%10*10;
            count++;
            if (count==90) break;
        }

        bw.write(String.valueOf(count));
        bw.close();



    }
}
