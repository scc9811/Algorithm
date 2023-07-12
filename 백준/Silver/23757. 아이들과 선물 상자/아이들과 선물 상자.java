import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur > priorityQueue.peek()){
                System.out.println(0);
                System.exit(0);
            }
            else{
                priorityQueue.add(priorityQueue.poll() - cur);
            }
        }
        System.out.println(1);

    }
}