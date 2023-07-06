import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] tArray = new Time[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            tArray[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(tArray);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(tArray[0].end);
        int maxDup = 1;
        for(int i=1; i<n; i++){
            while(!priorityQueue.isEmpty() && priorityQueue.peek()<=tArray[i].start){
                priorityQueue.poll();
            }
            priorityQueue.add(tArray[i].end);
            maxDup = Math.max(maxDup, priorityQueue.size());
        }
        System.out.println(maxDup);



    }
    static class Time implements Comparable<Time>{
        int start, end;
        Time(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Time t){
            return Integer.compare(this.start, t.start);
        }
    }
}
