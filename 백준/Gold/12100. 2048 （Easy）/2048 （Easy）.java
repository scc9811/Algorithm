import java.util.*;
import java.io.*;

public class Main {
    static int n, res, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        back(0);
        System.out.println(res);







    }
    static void back(int depth){
        if(depth==5){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    res = Math.max(res, arr[i][j]);
                }
            }
            return;
        }
        int[][] base = new int[n][n];
        for(int i=0; i<n; i++){
            base[i] = Arrays.copyOf(arr[i], n);
        }

        //right
        for(int i=0; i<n; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j=0; j<n; j++){
                if(arr[i][j]!=0) stack.add(arr[i][j]);
            }
            int pointer = n-1;

            while(!stack.isEmpty()){
                int k = stack.pop();
                if(!stack.isEmpty() && k==stack.peek()){
                    arr[i][pointer] = k*2;
                    stack.pop();
                }
                else {
                    arr[i][pointer] = k;
                }
                pointer--;
            }
            for(int j=pointer; j>=0; j--){
                arr[i][j] = 0;
            }
        }
        back(depth+1);
        for(int i=0; i<n; i++){
            arr[i] = Arrays.copyOf(base[i], n);
        }

        //left
        for(int i=0; i<n; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j=n-1; j>=0; j--){
                if(arr[i][j]!=0) stack.add(arr[i][j]);
            }
            int pointer = 0;

            while(!stack.isEmpty()){
                int k = stack.pop();
                if(!stack.isEmpty() && k==stack.peek()){
                    arr[i][pointer] = k*2;
                    stack.pop();
                }
                else {
                    arr[i][pointer] = k;
                }
                pointer++;
            }
            for(int j=pointer; j<n; j++){
                arr[i][j] = 0;
            }
        }
        back(depth+1);
        for(int i=0; i<n; i++){
            arr[i] = Arrays.copyOf(base[i], n);
        }

        // down
        for(int j=0; j<n; j++){
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<n; i++){
                if(arr[i][j]!=0) stack.add(arr[i][j]);
            }
            int pointer = n-1;

            while(!stack.isEmpty()){
                int k = stack.pop();
                if(!stack.isEmpty() && k==stack.peek()){
                    arr[pointer][j] = k*2;
                    stack.pop();
                }
                else {
                    arr[pointer][j] = k;
                }
                pointer--;
            }
            for(int i=pointer; i>=0; i--){
                arr[i][j] = 0;
            }
        }
        back(depth+1);
        for(int i=0; i<n; i++){
            arr[i] = Arrays.copyOf(base[i], n);
        }

        // up
        for(int j=0; j<n; j++){
            Stack<Integer> stack = new Stack<>();
            for(int i=n-1; i>=0; i--){
                if(arr[i][j]!=0) stack.add(arr[i][j]);
            }
            int pointer = 0;

            while(!stack.isEmpty()){
                int k = stack.pop();
                if(!stack.isEmpty() && k==stack.peek()){
                    arr[pointer][j] = k*2;
                    stack.pop();
                }
                else {
                    arr[pointer][j] = k;
                }
                pointer++;
            }
            for(int i=pointer; i<n; i++){
                arr[i][j] = 0;
            }
        }
        back(depth+1);



    }
}