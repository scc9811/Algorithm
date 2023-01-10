import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(minusQ.isEmpty()){
                    if(plusQ.isEmpty()) sb.append(0);
                    else sb.append(plusQ.poll());
                }
                else if(plusQ.isEmpty()) sb.append(minusQ.poll());
                else{
                    if(plusQ.peek()<Math.abs(minusQ.peek())) sb.append(plusQ.poll());
                    else sb.append(minusQ.poll());
                }
                sb.append('\n');
            }
            else if(n<0) minusQ.add(n);
            else plusQ.add(n);
        }
        System.out.println(sb);



    }


}