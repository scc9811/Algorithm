import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];
        for(int i=0; i<n; i++){
            array[i] = br.readLine();
        }
        int length = array[0].length();



        for(int i=1; i<=length; i++){
            boolean tf = false;
            int startI = length-i;
            for(int j=0; j<n; j++){
                String s = array[j].substring(startI,length);
                for(int k=j+1; k<n; k++){
                    if(s.equals(array[k].substring(startI,length))) {
                        tf = true;
                        break;
                    }
                }
                if(tf) break;
            }

            if(!tf){
                System.out.println(i);
                break;
            }

        }










    }
}