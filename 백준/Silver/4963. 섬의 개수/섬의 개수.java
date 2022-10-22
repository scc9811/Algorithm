import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w==0 && h==0) break;
            int[][] array = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            while (true){
                boolean tf = false;
                for (int i=0; i<h; i++){
                    for (int j=0; j<w; j++){
                        if (array[i][j]==1){
                            queue.add(new int[] {i,j});
                            array[i][j]=0;
                            tf = true;
                            break;
                        }
                    }
                    if (tf) break;
                }
                if (!tf) break;
                count++;

                while(!queue.isEmpty()){
                    int[] semiArray = queue.poll();
                    int i = semiArray[0];
                    int j = semiArray[1];
                    if(j+1<w){
                        if(array[i][j+1]==1){
                            array[i][j+1]=0;
                            queue.add(new int[] {i,j+1});
                        }
                        if(i+1<h && array[i+1][j+1]==1){
                            array[i+1][j+1]=0;
                            queue.add(new int[] {i+1,j+1});
                        }
                        if(i>0 && array[i-1][j+1]==1){
                            array[i-1][j+1]=0;
                            queue.add(new int[] {i-1,j+1});
                        }
                    }
                    if(j>0){
                        if(array[i][j-1]==1){
                            array[i][j-1]=0;
                            queue.add(new int[] {i,j-1});
                        }
                        if(i+1<h && array[i+1][j-1]==1){
                            array[i+1][j-1]=0;
                            queue.add(new int[] {i+1,j-1});
                        }
                        if(i>0 && array[i-1][j-1]==1){
                            array[i-1][j-1]=0;
                            queue.add(new int[] {i-1,j-1});
                        }
                    }
                    if(i+1<h && array[i+1][j]==1){
                        array[i+1][j]=0;
                        queue.add(new int[] {i+1,j});
                    }
                    if(i>0 && array[i-1][j]==1){
                        array[i-1][j]=0;
                        queue.add(new int[] {i-1,j});
                    }
                }
            }
            System.out.println(count);









        }

    }
}
