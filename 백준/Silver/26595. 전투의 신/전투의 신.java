import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long pa = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long pb = Integer.parseInt(st.nextToken());

        long maxScore = 0;
        long maxA = 0;
        long maxB = 0;
        for(long aCount=0; pa*aCount<=n; aCount++){
            long score = aCount*a + (n-aCount*pa)/pb*b;
            if(maxScore<score){
                maxA = aCount;
                maxB = (n-aCount*pa)/pb;
                maxScore = score;
            }
//            System.out.println("aCount = "+aCount);
//            System.out.println("bCount = "+(n-aCount*pa)/pb);
//            System.out.println("score = "+score);
//            System.out.println();
        }
        System.out.printf("%d %d",maxA, maxB);






    }
}