import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Integer> queue = new LinkedList<>();
    static int[][] array;
    static boolean[][] tfArray;
    static int size;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int max = 0;
        array = new int[size][size];
        tfArray = new boolean[size][size];
        for(int i=0; i<size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<size; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,array[i][j]);
            }
        }



        int safetyArea_max = 1;
        for(int i=1; i<=max+1; i++){
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(array[j][k]==i) array[j][k]=0;
                }
            }
            safetyArea_max = Math.max(safetyArea_max,countArea(i));
        }
        System.out.println(safetyArea_max);








    }
    public static int countArea(int depth){
        int count=0;
        int startI, startJ;
        while(true) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!tfArray[i][j] && array[i][j] > 0) {
                        queue.add(i);
                        queue.add(j);
                        tfArray[i][j]=true;
                        break;
                    }
                }
                if (!queue.isEmpty()) break;
            }
            if(queue.isEmpty()) break;

            while (!queue.isEmpty()) {

                startI = queue.poll();
                startJ = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if (newI >= 0 && newI < size && newJ >= 0 && newJ < size) {
                        if(array[newI][newJ]==0 || tfArray[newI][newJ]) continue;
                        queue.add(newI);
                        queue.add(newJ);
                        tfArray[newI][newJ]=true;
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < size; i++) {
            Arrays.fill(tfArray[i], false);
        }




        return count;
    }
}
