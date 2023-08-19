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
class Solution {
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





            for(int i=0; i<n; i++){
                System.out.println("n = "+(i+1));
                if(s.charAt(i) == '(') {
                    deepCount++;
                    stack.add('(');
                }
                else if(s.charAt(i) == '{') {
                    deepCount++;
                    stack.add('{');
                }
                else if(s.charAt(i) == '}') {
//                    boolean flag = true;
//                    if(continueCount[deepCount+1] == -1) flag = false;
                    continueCount[deepCount] = 0;
                    // yes
                    if(!stack.isEmpty() && stack.pop() == '{'){
//                        System.out.println("YES");
                        deepCount--;
//                        if(flag) continueCount[deepCount]++;
                        if(isValid[deepCount]) continueCount[deepCount]++;
                        else if(deepCount!=0) isValid[deepCount-1] = false;
                        isValid[deepCount] = true;
                        total += continueCount[deepCount];
                    }
                    // no
                    else{
                        if(deepCount!=0) deepCount--;
//                        continueCount[deepCount] = -1;
                        if(deepCount>0) isValid[deepCount-1] = false;
                    }
                }

                else if(s.charAt(i) == ')') {
//                    boolean flag = true;
//                    if(continueCount[deepCount+1] == -1) flag = false;
                    continueCount[deepCount] = 0;
                    // yes
                    if(!stack.isEmpty() && stack.pop() == '('){
//                        System.out.println("YES");
                        deepCount--;
//                        if(flag) continueCount[deepCount]++;
                        if(isValid[deepCount]) continueCount[deepCount]++;
                        else if(deepCount!=0)  isValid[deepCount-1] = false;
                        isValid[deepCount] = true;
                        total += continueCount[deepCount];
                    }
                    // no
                    else{
                        if(deepCount!=0) deepCount--;
//                        continueCount[deepCount] = -1;
                        if(deepCount>0) isValid[deepCount-1] = false;
                    }
                }
                for(int j=1; j<10; j++){
                    System.out.printf("%d ", continueCount[j]);
                }
                System.out.println();
                for(int j=1; j<10; j++){
                    System.out.printf("%b ",isValid[j]);
                }
                System.out.println();
                System.out.println("total = "+total);
                System.out.println("deep = "+deepCount);
                System.out.println();
            }
//            System.out.println(total);





            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
//            System.out.println("Case #"+(test_case+1));
//            System.out.println(Answer);
            sb.append("Case #").append(test_case+1).append('\n').append(total).append('\n');
        }
        System.out.println(sb);
    }
}