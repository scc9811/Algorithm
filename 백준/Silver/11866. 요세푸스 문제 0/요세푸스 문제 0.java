import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        int index=k-1;
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        sb.append(list.get(index)).append(',');
        list.remove(index);
        if(n!=1) index = (index+k-1)%list.size();
        else index=0;
        
        while(list.size()>0){
            sb.append(' ').append(list.get(index)).append(',');
            list.remove(index);
            try{
                index = (index+k-1)%list.size();
            }
            catch(ArithmeticException e){
                break;
            }
        }
        sb.delete(sb.length()-1,sb.length()).append('>');

        System.out.println(sb);















    }
}
