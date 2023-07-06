import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long cur = 1;
        Deque<Long> deque = new ArrayDeque<>();
        while(n>0){
            if(n%2==1) deque.add(cur);
            n /= 2;
            cur *= 2;
        }


        long res = 0;
        while(deque.size()>k){
            long l1 = deque.poll();
            long l2 = deque.poll();
            res += l2-l1;
            deque.addFirst(l2*2);
        }
        System.out.println(res);




















    }
}
