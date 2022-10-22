import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        int count=0;
        while(testCase-->0){
            boolean[] array = new boolean[26];
            String s = br.readLine();
            boolean tf = true;

            array[s.charAt(0)-97]=true;
            for (int i=1; i<s.length(); i++){
                if(s.charAt(i-1)==s.charAt(i)) continue;
                if(array[s.charAt(i)-97]){
                    tf=false;
                    break;
                }
                array[s.charAt(i)-97] = true;
            }
            if(tf) {
                count++;
            }
        }
        System.out.println(count);





    }
}