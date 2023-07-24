import java.util.*;
import java.io.*;


public class Main {
    static int n, m, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 1;
        for(int size=2; size <= Math.min(n, m); size++){
            if(size(size)) max = size*size;
        }
        System.out.println(max);






    }
    static boolean size(int size){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i+size-1 >= n || j+size-1 >= m) continue;
                if(arr[i][j]==arr[i+size-1][j] && arr[i][j]==arr[i][j+size-1] &&
                arr[i][j]==arr[i+size-1][j+size-1]) return true;
            }
        }

        return false;


    }
}


