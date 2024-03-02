import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // status
        // 0 : no visited,  1 : red,  2 : blue
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        if(br.readLine().charAt(0)=='B'){
            System.out.println(0);
            System.exit(0);
        }
        arr[0] = 1;
        arr[1] = 1;
        for(int i=1; i<n; i++){
//            System.out.println(Arrays.toString(arr));
            String s = br.readLine();
            int[] next = new int[n+1];
            for(int j=0; j<=i; j++){
                if(s.charAt(j)=='R'){
                    if(arr[j]==0){
                        if(next[j] != 0){
                            System.out.println(0);
                            System.exit(0);
                        }
                        next[j] = 1;
                        next[j+1] = 1;
                    }
                    else if(arr[j]==1){}
                    else if(arr[j]==2){
                        System.out.println(0);
                        System.exit(0);
                    }
                }
                else{
                    if(arr[j]==0){
                        if(j==i || s.charAt(j+1) != 'B'){
                            System.out.println(0);
                            System.exit(0);
                        }
                        else{
                            next[j+1] = 2;
                        }
                        j++;
                    }
                    else if(arr[j]==1){
                        System.out.println(0);
                        System.exit(0);
                    }
                    else if(arr[j]==2){}


                }
            }
            arr = next;
        }
//        System.out.println(Arrays.toString(arr));
        for(int i=0; i<=n; i++){
            if(arr[i] != 0){
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(1);

















    }
}