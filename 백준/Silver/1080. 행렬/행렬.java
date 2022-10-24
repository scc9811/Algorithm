import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

            // A행렬 생성.
            int[][] aArray = new int[N][M];
            for (int i=0; i<N; i++){
                String s = br.readLine();
                for (int j=0; j<M; j++){
                    aArray[i][j] = Integer.parseInt(s.substring(j,j+1));
                }
            }
            // B행렬 생성.
            int[][] bArray = new int[N][M];
            for (int i=0; i<N; i++){
                String s = br.readLine();
                for (int j=0; j<M; j++){
                    bArray[i][j] = Integer.parseInt(s.substring(j,j+1));
                }
            }

            int count =0;
            for (int i=0; i<N-2; i++){
                for (int j=0; j<M-2; j++){
                    if(aArray[i][j] != bArray[i][j]){
                        count++;
                        transfer(aArray,i,j);
                    }
                }
            }

            if (Comparator(aArray,bArray)) System.out.println(count);
            else System.out.println(-1);





//            for (int i=0; i<N; i++){
//                for (int j=0; j<M; j++){
//                    System.out.print(Barray[i][j]);
//                }
//                System.out.println();
//            }







    }
    public static void transfer(int[][] array, int a, int b){
        for (int i=a; i<a+3; i++){
            for (int j=b; j<b+3; j++){
                if(array[i][j]==1) array[i][j]=0;
                else array[i][j]=1;
            }
        }
    }
    public static boolean Comparator(int[][] aArray, int[][] bArray){
        for (int i=0; i<aArray.length; i++){
            for (int j=0; j<aArray[0].length; j++){
                if (aArray[i][j] != bArray[i][j]) return false;
            }
        }
        return true;
    }
}
