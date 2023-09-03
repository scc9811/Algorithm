import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] lists = new List[6];
        for(int i=1; i<=5; i++){
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ps = new int[6];
        for(int i=1; i<=5; i++){
            ps[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            lists[num].add(time);
        }
        

        long sum = 0;
        for(int i=1; i<=5; i++){
            if(ps[i]==0) continue;
            Collections.sort(lists[i]);
            if(!lists[i].isEmpty() && i!=1) sum += 60;
            sum += lists[i].get(0);
            for(int j=1; j<ps[i]; j++){
                sum += lists[i].get(j);
                sum += lists[i].get(j) - lists[i].get(j-1);
            }
        }

        System.out.println(sum);

















    }
}