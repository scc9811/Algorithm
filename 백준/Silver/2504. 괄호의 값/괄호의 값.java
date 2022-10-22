import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int[] levelArray = new int[30];
        int level = 1;
        boolean tf = true;
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case '(': stack.add('('); level++; break;
                case '[': stack.add('['); level++; break;
                case ')':{
                    if(stack.isEmpty() || stack.peek()!='('){
                        tf = false;
                        break;
                    }
                    stack.pop();
                    if(levelArray[level]!=0) levelArray[level-1] += levelArray[level]*2;
                    else levelArray[level-1] += 2;
                    levelArray[level--] = 0;
                    break;
                }
                case ']':{
                    if(stack.isEmpty() || stack.peek()!='['){
                        tf = false;
                        break;
                    }
                    stack.pop();
                    if(levelArray[level]!=0) levelArray[level-1] += levelArray[level]*3;
                    else levelArray[level-1] += 3;
                    levelArray[level--] = 0;
                    break;
                }
            }

            if(!tf) break;




        }
        if(tf && stack.isEmpty()){
            System.out.println(levelArray[1]);
        }
        else System.out.println(0);






    }
}
