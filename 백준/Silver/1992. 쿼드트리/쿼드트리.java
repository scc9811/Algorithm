import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        divide(0, 0, n);
        System.out.println(sb);








    }
    public static void divide(int startI, int startJ, int size){
        if(size==1){
            sb.append(arr[startI][startJ]);
            return;
        }
        char c = arr[startI][startJ];
        boolean tf = true;
        for(int i=startI; i<startI+size; i++){
            for(int j=startJ; j<startJ+size; j++){
                if(arr[i][j]!=c){
                    tf = false;
                    break;
                }
            }
            if(!tf) break;
        }
        if(!tf){
            sb.append('(');
            divide(startI, startJ, size/2);
            divide(startI, startJ+size/2, size/2);
            divide(startI+size/2, startJ, size/2);
            divide(startI+size/2, startJ+size/2, size/2);
            sb.append(')');
        }
        else{
            sb.append(c);
        }




    }
}

