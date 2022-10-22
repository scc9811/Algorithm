import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int sequence = 0;
        int time = 0;
        int qWeight = 0;
        while(sequence<n){
            if(queue.size()==w) qWeight -= queue.poll();
            if(qWeight+weight[sequence]>l) queue.add(0);
            else{
                queue.add(weight[sequence]);
                qWeight += weight[sequence++];
            }


            time++;
        }

        time += w;

        System.out.println(time);

    }
}
