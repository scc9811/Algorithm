import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int whiteCount = 0;
    static int blueCount = 0;
    static int[][] array;
    private int k=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        array = new int[size][size];
        for(int i=0; i<size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(0,0,size);
        System.out.println(whiteCount);
        System.out.println(blueCount);















    }
    public static void division(int startI, int startJ, int count){
        boolean tf = true;
        int criteria = array[startI][startJ];
        for(int i=startI; i<startI+count; i++){
            for(int j=startJ; j<startJ+count; j++){
                if(criteria!=array[i][j]){
                    tf = false;
                    break;
                }

            }
            if(!tf) break;
        }

        if(!tf){
            for(int i=startI; i<startI+count; i+=count/2){
                for(int j=startJ; j<startJ+count; j+=count/2){
                    division(i,j,count/2);
                }
            }

        }

        else{
            if(criteria==0) whiteCount++;
            else blueCount++;
        }





    }



}