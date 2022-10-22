import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            Stack<Integer> stack = new Stack<>();
            String s = br.readLine();
            if (s.equals(".")) break;

            int count=0;
            int k = s.length();
            boolean tf = true;
            for (int i=0; i<k; i++){
                if (s.charAt(i)=='(') stack.add(0);
                else if(s.charAt(i)=='[') stack.add(1);
                else if(s.charAt(i)==')'){
                    if (stack.isEmpty() || stack.pop()!=0){
                        tf = false;
                        break;
                    }
                }
                else if(s.charAt(i)==']'){
                    if (stack.isEmpty() || stack.pop()!=1){
                        tf = false;
                        break;
                    }
                }
            }


            if (s.charAt(k-1)!='.') continue;

            if(!tf || !stack.isEmpty()) sb.append("no");
            else sb.append("yes");
            sb.append('\n');
        }
        System.out.println(sb);









    }

}
