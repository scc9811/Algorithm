import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] priorityQueues = new PriorityQueue[12];
        for(int i=1; i<=11; i++){
            priorityQueues[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            priorityQueues[num].add(val);
        }

        for(int i=0; i<k; i++){
            for(int num=1; num<=11; num++){
                if(priorityQueues[num].isEmpty()) continue;
                priorityQueues[num].add(priorityQueues[num].poll()-1);
            }
        }

        int sum = 0;
        for(int i=1; i<=11; i++){
            if(priorityQueues[i].isEmpty()) continue;
            sum += priorityQueues[i].poll();
        }

        System.out.println(sum);

















    }
}