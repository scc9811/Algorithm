import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean tf = false;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='0'){
                tf = true;
                break;
            }
        }
        if (tf==false) System.out.println(-1);
        else{
            int sum =0;
            for (int i=0; i<s.length(); i++)
                sum += Integer.parseInt(s.substring(i, i + 1));

            if (sum%3!=0) System.out.println(-1);
            else{
                int[] array = new int[s.length()];
                for (int i = 0;i <array.length; i++){
                    array[i] = Integer.parseInt(s.substring(i,i+1));
                }
                Arrays.sort(array);
                StringBuilder sb = new StringBuilder("");
                for (int i=array.length-1; i>=0; i--){
                    sb.append(array[i]);
                }
                System.out.println(sb);
            }

        }





    }
}
