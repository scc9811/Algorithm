import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int res = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j+1<n){
                    char[][] tmp = new char[n][n];
                    for(int k=0; k<n; k++){
                        tmp[k] = Arrays.copyOf(arr[k], n);
                    }
                    char tmpC = tmp[i][j];
                    tmp[i][j] = tmp[i][j+1];
                    tmp[i][j+1] = tmpC;
                    res = Math.max(res, count(tmp));
                }
                if(i+1<n){
                    char[][] tmp = new char[n][n];
                    for(int k=0; k<n; k++){
                        tmp[k] = Arrays.copyOf(arr[k], n);
                    }
                    char tmpC = tmp[i][j];
                    tmp[i][j] = tmp[i+1][j];
                    tmp[i+1][j] = tmpC;
                    res = Math.max(res, count(tmp));
                }
            }
        }
        System.out.println(res);









    }
    static int n;
    static int count(char[][] arr){
        int ret = 0;
        for(int i=0; i<n; i++){
            int count = 1;
            for(int j=1; j<n; j++){
                if(arr[i][j] == arr[i][j-1]) count++;
                else{
                    ret = Math.max(ret, count);
                    count = 1;
                }
            }
            ret = Math.max(ret, count);
        }

        for(int j=0; j<n; j++){
            int count = 1;
            for(int i=1; i<n; i++){
                if(arr[i][j] == arr[i-1][j]) count++;
                else{
                    ret = Math.max(ret, count);
                    count = 1;
                }
            }
            ret = Math.max(ret, count);
        }

        return ret;
    }
}