import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(priorityQueue.isEmpty()) sb.append(0);
                else sb.append(priorityQueue.poll());
                sb.append('\n');
                continue;
            }
            priorityQueue.add(n);


        }
        System.out.println(sb);













    }
}