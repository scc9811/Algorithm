import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int sumX = 0;
        int sumY = 0;

        try{
            st = new StringTokenizer(br.readLine());
        }
        catch(NullPointerException ignore){}
        for(int i=0; i<n-1; i++){
            sumX += Integer.parseInt(st.nextToken());
        }

        try{
            st = new StringTokenizer(br.readLine());
        }
        catch(NullPointerException ignore){}
        for(int i=0; i<e-1; i++){
            sumY += Integer.parseInt(st.nextToken());
        }



        double result = Math.pow((sumX*sumX + sumY*sumY),0.5);
        System.out.println((int)Math.ceil(result));







    }
}