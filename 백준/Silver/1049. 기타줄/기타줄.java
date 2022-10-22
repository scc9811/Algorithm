import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int minPackage = 1000;
        int minEach = 1000;

        while (M-- >0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            minPackage = Math.min(minPackage, Integer.parseInt(st2.nextToken()));
            minEach = Math.min(minEach, Integer.parseInt(st2.nextToken()));
        }

        if (minPackage>=minEach*6) System.out.println(minEach*N);
        else{
            System.out.println(Math.min(minPackage*(N/6) + minEach*(N%6),minPackage*(N/6+1)));
        }







    }
}
