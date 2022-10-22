import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==0) {
                if(priorityQueue.isEmpty()) sb.append(0);
                else sb.append(priorityQueue.poll());
                sb.append('\n');
            }
            else priorityQueue.add(n);
        }
        System.out.println(sb);













    }
}