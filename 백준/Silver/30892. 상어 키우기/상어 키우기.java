import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long sum = t;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n && k>0; i++){
            if(arr[i] >= sum){
                if(stack.isEmpty()){
                    break;
                }
                else{
                    sum += stack.pop();
                    k--;
                    i--;
                }
            }
            else{
                stack.add(arr[i]);
            }
        }

        while(!stack.isEmpty() && k > 0){
            sum += stack.pop();
            k--;
        }

        System.out.println(sum);






    }
}