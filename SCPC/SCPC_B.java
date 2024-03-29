/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution01 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
//        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            long total = 0;
            int[] continueCount = new int[1000002];
            int deepCount = 0;
            boolean[] isValid = new boolean[1000002];
            Arrays.fill(isValid, true);





            boolean lastClosed = false;
            for(int i=0; i<n; i++){
                if(s.charAt(i) == '(') {
                    deepCount++;
                    stack.add('(');
                }
                else if(s.charAt(i) == '{') {
                    deepCount++;
                    stack.add('{');
                }
                else if(s.charAt(i) == ')'){
                    continueCount[deepCount] = 0;
                    if(stack.isEmpty()){
                        continueCount[0] = 0;
                    }
                    // ok
                    else if(stack.pop() == '('){
                        deepCount--;
                        if(isValid[deepCount]) continueCount[deepCount]++;
                        else {
                            continueCount[deepCount] = 0;
                            isValid[deepCount] = true;
                            if(deepCount-1 >= 0) isValid[deepCount-1] = false;
                        }
                        total += continueCount[deepCount];

                    }
                    // no
                    else{
                        continueCount[deepCount-1] = 0;
                        deepCount--;
                        isValid[deepCount] = true;
                        if(deepCount-1 >= 0) isValid[deepCount-1] = false;
                    }
                    lastClosed = true;
                }
                else if(s.charAt(i) == '}'){
                    continueCount[deepCount] = 0;
                    if(stack.isEmpty()){
                        continueCount[0] = 0;
                    }
                    // ok
                    else if(stack.pop() == '{'){
                        deepCount--;
                        if(isValid[deepCount]) continueCount[deepCount]++;
                        else {
                            continueCount[deepCount] = 0;
                            isValid[deepCount] = true;
                            if(deepCount-1 >= 0) isValid[deepCount-1] = false;
                        }
                        total += continueCount[deepCount];

                    }
                    // no
                    else{
                        continueCount[deepCount-1] = 0;
                        deepCount--;
                        isValid[deepCount] = true;
                        if(deepCount-1 >= 0) isValid[deepCount-1] = false;
                    }
                    lastClosed = true;
                }




            }





            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
//            System.out.println("Case #"+(test_case+1));
//            System.out.println(total);
            sb.append("Case #").append(test_case+1).append('\n').append(total).append('\n');
        }
        System.out.println(sb);
    }
}