import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.add(i);
        }

        int tmp=1;
        while(queue.size()>1){
            long step = (long) Math.pow(tmp,3);
            int count = (int) (step % queue.size());
            if(count==0) count=queue.size();

            for(int i=0; i<count-1; i++){
                queue.add(queue.poll());
            }


            queue.poll();



            tmp++;
        }
        System.out.println(queue.poll()+1);










    }
}