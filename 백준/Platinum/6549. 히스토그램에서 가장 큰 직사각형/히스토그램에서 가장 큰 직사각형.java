import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            Map<Long, Integer> map = new HashMap<>();
            long maxWidth = 0;
            for (int i=0; i<n; i++){
                long h = Long.parseLong(st.nextToken());
                if(priorityQueue.isEmpty() || h>priorityQueue.peek()){
                    priorityQueue.add(h);
                    map.put(h,i);
                    continue;
                }
                else if(h==priorityQueue.peek()) continue;


                //  현재상태 stack.peek()>h
                int index = i-1;
                while(true){
                    if(priorityQueue.isEmpty()){
                        priorityQueue.add(h);
                        map.put(h,0);
                        break;
                    }


                    else if(priorityQueue.peek()==h){
                        break;
                    }


                    else if(priorityQueue.peek()<h){
                        priorityQueue.add(h);
                        map.put(h,index);

                        break;
                    }

                    else if(priorityQueue.peek()>h){
                        index = map.get(priorityQueue.peek());
                        maxWidth = Math.max(maxWidth, priorityQueue.peek()*(i-index));
                        map.remove(priorityQueue.poll());
                    }


                }


            }

            while(!priorityQueue.isEmpty()){
                maxWidth = Math.max(maxWidth, priorityQueue.peek()*(n-map.get(priorityQueue.poll())));
            }


            sb.append(maxWidth).append('\n');

        }
        System.out.println(sb);



    }
}