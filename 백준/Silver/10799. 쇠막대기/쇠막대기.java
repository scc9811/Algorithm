import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int qSize = 0;
        boolean isLastOpen = false;
        int total = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') {
                qSize++;
                isLastOpen = true;
            }
            else{
                qSize--;
                if(isLastOpen){
                    total += qSize;
                }
                else total++;
                isLastOpen = false;
            }
        }
        System.out.println(total);





    }
}
