import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime(i)) primeNumbers.add(i);
        }

        
        int size = primeNumbers.size();
        int left = -1;
        int right = 0;
        int sum = 0;
        int res = 0;
        
        while(true){
            if(sum==n){
                res++;
                left++;
                sum -= primeNumbers.get(left);
            }
            else if(sum < n){
                right++;
                if(right==size+1) break;
                sum += primeNumbers.get(right-1);
            }
            else{
                left++;
                sum -= primeNumbers.get(left);
            }
        }
        System.out.println(res);










    }
    static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}