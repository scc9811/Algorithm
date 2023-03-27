import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        long res = 0;
        for(int i=0; i <n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            priorityQueue.add(arr[i]);
            if(sum>=m){
                sum -= priorityQueue.poll()*2;
                res++;
            }
        }



        System.out.println(res);





    }
}
