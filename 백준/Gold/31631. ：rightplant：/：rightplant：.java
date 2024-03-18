import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> R = new ArrayList<>();
        List<Integer> L = new ArrayList<>();
        int sumR = n;
        int sumL = 0;
        R.add(n);
        for(int i=n-1; i>=1; i--){
            if(L.size() < R.size()){
                L.add(i);
                sumL += i;
            }
            else if(L.size() > R.size()){
                R.add(i);
                sumR += i;
            }
            else{
                if(sumL < sumR){
                    sumL += i;
                    L.add(i);
                }
                else{
                    sumR += i;
                    R.add(i);
                }
            }
        }
        Collections.reverse(R);
        for(int i : L){
            sb.append(i).append(' ');
        }
        for(int i : R){
            sb.append(i).append(' ');
        }





        System.out.println(sb);


















    }
}