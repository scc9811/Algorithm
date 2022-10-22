import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] checkArray = new int[100001];
        int count=0;
        queue.add(start);
        checkArray[start]=1;
        int tmp=1;
        while(true){
            int n = queue.poll();
            if(n==end) break;
            if(n*2<100001 && checkArray[n*2]==0) {
                checkArray[n*2]=1;
                queue.add(n*2);
            }
            if(n>0 && checkArray[n-1]==0){
                checkArray[n-1]=1;
                queue.add(n-1);
            }
            if(n+1<100001 && checkArray[n+1]==0) {
                checkArray[n+1]=1;
                queue.add(n+1);
            }
            tmp--;

            if(tmp==0){
                count++;
                tmp=queue.size();
            }

        }
        System.out.println(count);













    }

}
