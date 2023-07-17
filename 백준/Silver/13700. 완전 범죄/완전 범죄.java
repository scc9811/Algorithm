import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        try {
            st = new StringTokenizer(br.readLine());
        }
        catch(NullPointerException ignore){
        }
        for(int i=0; i<k; i++){
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        if(s==d) {
            System.out.println(0);
            System.exit(0);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int tmp = 1;


        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            int cur = queue.poll();
            int front = cur + f;
            int back = cur - b;
            if(front==d || back==d){
                System.out.println(count);
                System.exit(0);
            }
            if(front <= n && !visited[front]){
                queue.add(front);
                visited[front] = true;
            }
            if(back > 0 && !visited[back]){
                queue.add(back);
                visited[back] = true;
            }
        }
        System.out.println("BUG FOUND");







    }
}