import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] array = new char[2*N];
        int count =0;
//        ArrayList<Character> arrayList = new ArrayList<Character>();

        int start = Integer.parseInt(br.readLine());
        N--;

        for (int i=1; i<=start; i++){
            stack.add(i);
            array[count++] = '+';
        }
        stack.pop();


        array[count++] = '-';


        int tmp = start;
        boolean tf = true;
        while (N-->0){
            int n = Integer.parseInt(br.readLine());
            if(tmp>n){
                if(stack.peek()==n){
                    stack.pop();
                    array[count++] = '-';
                }
                else {
                    tf = false;
                    break;
                }
            }
            else if(tmp<n){
                for (int i=tmp+1; i<=n; i++){
                    stack.add(i);
                    array[count++] = '+';
                }
                stack.pop();
                array[count++] = '-';
                tmp = n;

            }


        }
        if (tf){
            for (int i=0; i<array.length; i++){
                bw.write(array[i]+"\n");
            }
        }
        else bw.write("NO");






        bw.close();
    }
}
