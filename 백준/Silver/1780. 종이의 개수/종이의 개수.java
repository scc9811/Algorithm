import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,n);
        for(int i=0; i<3; i++){
            System.out.println(result[i]);
        }





    }
    // -1, 0, 1
    static int[] result = new int[3];
    static public void divide(int startI, int startJ, int size){
        int base = arr[startI][startJ];
        boolean tf = true;
        for(int i=startI; i<startI+size; i++){
            for(int j=startJ; j<startJ+size; j++){
                if(arr[i][j]!=base){
                    tf = false;
                    break;
                }
            }
            if(!tf) break;
        }
        if(tf){
            if(base==-1) result[0]++;
            else if(base==0) result[1]++;
            else if(base==1) result[2]++;
        }
        else{
            divide(startI, startJ, size/3);
            divide(startI+size/3, startJ, size/3);
            divide(startI+size*2/3, startJ, size/3);

            divide(startI, startJ+size/3, size/3);
            divide(startI+size/3, startJ+size/3, size/3);
            divide(startI+size*2/3, startJ+size/3, size/3);

            divide(startI, startJ+size*2/3, size/3);
            divide(startI+size/3, startJ+size*2/3, size/3);
            divide(startI+size*2/3, startJ+size*2/3, size/3);





        }




    }
}