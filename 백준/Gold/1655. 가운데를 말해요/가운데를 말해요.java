import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();
        leftQ.add(-100000);
        rightQ.add(100000);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            int mid = 0;
            if(i%2==1){
                if(leftQ.size()<rightQ.size()) leftQ.add(k);
                else rightQ.add(k);
                if(leftQ.peek()>rightQ.peek()){
                    int tmp = rightQ.poll();
                    rightQ.add(leftQ.poll());
                    leftQ.add(tmp);
                }
                mid = Math.min(rightQ.peek(), leftQ.peek());
            }
            else{
                if(k<leftQ.peek()) {
                    leftQ.add(k);
                    mid = leftQ.peek();
                }
                else {
                    rightQ.add(k);
                    mid = rightQ.peek();
                }
            }
            sb.append(mid).append('\n');
        }
        System.out.println(sb);






    }
}