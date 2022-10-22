import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];
        for(int i=0; i<n; i++){
            array[i] = br.readLine();
        }

        Arrays.sort(array);
        Arrays.sort(array, Comparator.comparing(String::length));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i!=0 && array[i-1].equals(array[i])) continue;
            else sb.append(array[i]).append('\n');
        }

        System.out.println(sb);







    }
}
