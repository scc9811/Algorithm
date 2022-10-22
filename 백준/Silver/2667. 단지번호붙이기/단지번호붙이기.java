import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];

        for (int i=0; i<N; i++){
            String s =  br.readLine();
            for (int j=0; j<N; j++){
                array[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        int count = 0;

        while (true){
            boolean tf = false;
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if (array[i][j]==1){
                        queue.add(new int[]{i,j});
                        array[i][j] = 0;
                        count++;
                        tf = true;
                        break;
                    }
                }
                if(tf) break;
            }
            if (!tf) break;

            int count2 = 1;
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];

                if (j+1<N && array[i][j+1]==1){
                    queue.add(new int[]{i,j+1});
                    array[i][j+1] = 0;
                    count2++;
                }
                if (j>0 && array[i][j-1]==1){
                    queue.add(new int[]{i,j-1});
                    array[i][j-1] = 0;
                    count2++;
                }
                if (i+1<N && array[i+1][j]==1){
                    queue.add(new int[]{i+1,j});
                    array[i+1][j] = 0;
                    count2++;
                }
                if (i>0 && array[i-1][j]==1){
                    queue.add(new int[]{i-1,j});
                    array[i-1][j] = 0;
                    count2++;
                }

            }

            arrayList.add(count2);
        }
        System.out.println(count);
        Collections.sort(arrayList);
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }


//        for (int k=0; k<N; k++){
//            System.out.println(Arrays.toString(array[k]));
//        }
//        System.out.println();



    }
}
