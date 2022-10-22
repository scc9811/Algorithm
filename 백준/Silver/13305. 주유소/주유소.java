import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(br.readLine());
        long sum =0;
        StringTokenizer road = new StringTokenizer(br.readLine());
        StringTokenizer price = new StringTokenizer(br.readLine());

        long min = Integer.parseInt(price.nextToken());
        sum += min*Integer.parseInt(road.nextToken());
        cities--;
        while (--cities >0){
            min = Math.min(min, Integer.parseInt(price.nextToken()));
            sum += min*Integer.parseInt((road.nextToken()));
        }

        System.out.println(sum);



    }
}
