import java.io.*;
import java.util.*;
public class Main{
    static List<Integer> primeNumbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        primeNumbers = new ArrayList<>();
        getPrime(n);


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
    static void getPrime(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                primeNumbers.add(i);
                int tmp = i;
                while(tmp <= n){
                    isPrime[tmp] = false;
                    tmp += i;
                }
            }
        }
    }
}