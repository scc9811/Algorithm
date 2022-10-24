import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long from = Integer.parseInt(st.nextToken());
            long to = Integer.parseInt(st.nextToken());
            long result =1;
            long tmp= 1;

            for (int i =0; i<from; i++){
                result = result*to/tmp;
                to--;
                tmp++;
            }
            System.out.println(result);

        }


    }
}
