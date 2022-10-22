import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] array = new int[1000][1000];
    public static void main(String[] args)throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int tmp = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j]==1){
                    queue.add(i);
                    queue.add(j);
                    tmp++;
                }
            }
        }



        int i = 0;
        int j = 0;
        int day = 0;
        while (!queue.isEmpty()){
            i = queue.poll();
            j = queue.poll();
            if(i+1<N && array[i+1][j]==0){
                array[i+1][j] = 1;
                queue.add(i+1);
                queue.add(j);
            }
            if(i-1>-1 && array[i-1][j]==0){
                array[i-1][j] = 1;
                queue.add(i-1);
                queue.add(j);
            }
            if(j+1<M && array[i][j+1]==0){
                array[i][j+1] = 1;
                queue.add(i);
                queue.add(j+1);
            }
            if (j-1>-1 && array[i][j-1]==0){
                array[i][j-1] = 1;
                queue.add(i);
                queue.add(j-1);
            }
            tmp--;
            if (tmp==0){
                day++;
                tmp = queue.size()/2;
            }


//            for(int k=0; k<N; k++){
//                System.out.println(Arrays.toString(array[k]));
//            }
//            System.out.println();

        }
        boolean tf = true;
        for (i=0; i<N; i++){
            for (j=0; j<M; j++){
                if (array[i][j]==0){
                    tf = false;
                    break;
                }
            }
        }
        if (tf) System.out.println(day-1);
        else  System.out.println(-1);





    }
}
