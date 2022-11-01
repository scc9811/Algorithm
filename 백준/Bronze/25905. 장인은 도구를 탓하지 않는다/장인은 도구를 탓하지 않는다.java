import javax.swing.text.html.InlineView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = new double[10];
        for(int i=0; i<10; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        double tmp = 2*3*4*5*6*7*8*9;

        Arrays.sort(arr);
        double sum = 1.0;
        for(int i=9; i>0; i--){
            sum *= arr[i];
        }
        double result = sum/tmp;
        System.out.println(result*1e9);


    }
}