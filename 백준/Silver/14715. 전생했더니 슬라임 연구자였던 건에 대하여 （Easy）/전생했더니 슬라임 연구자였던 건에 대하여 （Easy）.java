import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[] array;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        visited = new boolean[n+1];


        System.out.println(scratch(n));








    }
    public static int scratch(int n){
        if(visited[n]) return array[n];

        else{
            for(int i=2; i*i<=n; i++){
                if(n%i==0){
                    int sum=0;
                    sum += Math.max(scratch(n/i),scratch(i))+1;
                    if(array[n]==0) {
                        array[n] = sum;
                        visited[n] = true;
                        }
                    else array[n] = Math.min(array[n],sum);
                }
            }
        }

        return array[n];

    }
}