import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        Map<Long, Long> map = new HashMap<>();
        map.put(x, 0L);

        for(long i=1; i<=n; i++){
            if(x%2==0) x = (x/2)^6;
            else x = (x*2)^6;

            long get = map.getOrDefault(x, -1L);
            if(get!=-1){
                long dif = i-get;
                long k = (n-i)%dif;
                for(long j=0; j<k; j++){
                    if(x%2==0) x = (x/2)^6;
                    else x = (x*2)^6;
                }
                System.out.println(x);
                System.exit(0);


            }
            map.put(x, i);
        }
        System.out.println(x);







    }
}
