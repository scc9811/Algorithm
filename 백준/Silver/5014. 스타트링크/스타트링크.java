import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f+1];
        if(s==g){
            System.out.println(0);
            System.exit(0);
        }
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int tmp = 1;
        int count = 0;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                tmp = queue.size();
                count++;
            }
            int cur = queue.poll();
            int up = cur + u;
            int down = cur - d;

            if(up <= f && !visited[up]){
                if(up == g){
                    System.out.println(count);
                    System.exit(0);
                }
                visited[up] = true;
                queue.add(up);
            }

            if(down > 0 && !visited[down]){
                if(down == g){
                    System.out.println(count);
                    System.exit(0);
                }
                visited[down] = true;
                queue.add(down);
            }



        }

        System.out.println("use the stairs");






    }
}
