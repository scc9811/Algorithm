import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        PriorityQueue<Height> priorityQueue = new PriorityQueue<>();

        int[] A = new int[n];
        int[] B = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        long tmp = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            B[i] = Integer.parseInt(st.nextToken());
            tmp += B[i];
            priorityQueue.add(new Height(i, A[i]-tmp));
        }
//        System.out.println(priorityQueue.peek().height);

        long count = 0;
        long curWeight = 0;
        tmp = 0;
        for(int i=0; i<n; i++){
            
            curWeight += B[i];
            tmp += B[i];
            while(priorityQueue.peek().id<i){
                priorityQueue.poll();
            }
            Height h = priorityQueue.peek();
            long height = h.height+tmp;
            if(curWeight<height){
                System.out.println(-1);
                System.exit(0);
            }

            long tmp2 = (curWeight-height)/x;
            count += tmp2;
            if(tmp2!=0) curWeight -= tmp2*x;
//            System.out.println("h = "+height);
//            System.out.println("curW = "+curWeight);
//            System.out.println("count = "+count);



//            long tmp = (curWeight-nextHeight)/x;
//            count += tmp;
//            curWeight -= tmp*x;
//            if(curWeight<(h.height+ (long) i *x)){
//                System.out.println(-1);
//                System.exit(0);
//            }
//            long tmp2 = (curWeight-(h.height+ (long) i *x))/x;
//            count += tmp2;
//            curWeight -= tmp2*x;
        }
        System.out.println(count);





    }
    static class Height implements Comparable<Height>{
        long id, height;
        Height(long id, long height){
            this.id = id;
            this.height = height;
        }
        public int compareTo(Height h){
            return Long.compare(h.height, this.height);
        }
    }
}
