import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!queue.isEmpty()){
                queue.add(s.charAt(i));
                if(s.charAt(i)=='>'){
                    while(!queue.isEmpty()){
                        sb.append(queue.poll());
                    }
                }
            }
            else if(s.charAt(i)=='<' || s.charAt(i)==' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                if(s.charAt(i)=='<') queue.add(s.charAt(i));
                else sb.append(' ');
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);









    }
}