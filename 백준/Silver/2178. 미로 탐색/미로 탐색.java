import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array = new int[N][M];

        for (int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        int count =0;

        queue.add(new int[] {0,0});
        array[0][0] = 0;
        count++;
        int tmp = 1;
        while(true){
            int[] semiArray = queue.poll();
            int i=semiArray[0];
            int j=semiArray[1];
            if (i==N-1 && j==M-1) break;

            if (i+1<N && array[i+1][j]==1){
                queue.add(new int[] {i+1,j});
                array[i+1][j] = 0;
            }
            if (i>0 && array[i-1][j]==1){
                queue.add(new int[] {i-1,j});
                array[i-1][j] = 0;
            }
            if (j+1<M && array[i][j+1]==1){
                queue.add(new int[] {i,j+1});
                array[i][j+1] = 0;
            }
            if (j>0 && array[i][j-1]==1){
                queue.add(new int[] {i,j-1});
                array[i][j-1] = 0;
            }
            tmp--;
            if (tmp==0){
                tmp = queue.size();
                count++;
            }






        }
        System.out.println(count);













    }
}
