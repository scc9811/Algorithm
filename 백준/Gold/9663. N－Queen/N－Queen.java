import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n,count;
    static int[][] array;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count=0;
        array = new int[n][n];

        Queen(0);
        System.out.println(count);









    }

    public static void Queen(int depth){
        if(depth==n) {
            count++;
            return;
        }

        // 행 단위로 진행. 한 행에 1개 퀸
        // but 대각선이나 세로선에 다른 퀸과 겹치면 안됨.

        for (int j=0; j<n; j++){
            if(tf(depth,j)){
                array[depth][j]=1;
                Queen(depth+1);
                array[depth][j]=0;
            }
        }


    }
    // 현재 array[i][j]가 공격받는 위치인지 판별하는 메소드.
    public static boolean tf(int i, int j){
        for(int k=0; k<n; k++){
            if(array[k][j]!=0) return false;
        }
        int tmpI=i+1;
        int tmpJ=j+1;
        while(tmpI<n && tmpJ<n){
            if(array[tmpI][tmpJ]!=0){
                return false;
            }
            tmpI++;
            tmpJ++;
        }
        tmpI=i+1;
        tmpJ=j-1;
        while(tmpI<n && tmpJ>=0){
            if(array[tmpI][tmpJ]!=0){
                return false;
            }
            tmpI++;
            tmpJ--;
        }
        tmpI=i-1;
        tmpJ=j+1;
        while(tmpI>=0 && tmpJ<n){
            if(array[tmpI][tmpJ]!=0){
                return false;
            }
            tmpI--;
            tmpJ++;
        }
        tmpI=i-1;
        tmpJ=j-1;
        while(tmpI>=0 && tmpJ>=0){
            if(array[tmpI][tmpJ]!=0){
                return false;
            }
            tmpI--;
            tmpJ--;
        }
        return true;

    }
}
