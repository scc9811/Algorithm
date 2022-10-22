import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        int count =1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int result = 0;
            if(L==0 && P==0 && V==0) break;
            while (V>=P){
                V -=P;
                result +=L;
            }
            if(V>=L) result +=L;
            else result += V;
            System.out.printf("Case %d: %d\n",count++,result);
        }






    }
}
