/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution11 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            int res = 0;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());


            int[][] left_right = new int[n][2];
            for(int count=0; count<m; count++){
//                System.out.println("count = "+count);
                int max = 0;
                int idx = -1;
                for(int i=0; i<n; i++){
                    if(visited[i]) continue;
//                    System.out.println("i = "+i);
                    int pointCounter_left = 0;
                    int pointCounter_right = 0;
                    int break_leftIdx = Math.max(0, i-t);
                    int break_rightIdx = Math.min(n, i+t);
                    for(int left = i-1; left>=Math.max(0, i-t-1); left--){
                        if(visited[left] || arr[left]==2){
                            break_leftIdx = left+1;
                            break;
                        }
                        pointCounter_left++;
                    }

                    for(int right = i+1; right<Math.min(n, i+t+1); right++){
                        if(visited[right] || arr[right]==2) {
                            break_rightIdx = right-1;
                            break;
                        }
                        pointCounter_right++;
                    }
//                    System.out.println("left = "+pointCounter_left);
//                    System.out.println("right = "+pointCounter_right);
                    if(break_rightIdx == n) break_rightIdx = n-1;
                    if(break_leftIdx == -1) break_leftIdx = 0;
                    if(max < pointCounter_left + pointCounter_right){
                        max = pointCounter_left + pointCounter_right;
                        idx = i;
                        left_right[i][0] = break_leftIdx;
                        left_right[i][1] = break_rightIdx;
                    }
                }
//                System.out.println("max = "+max);
                if(max == 0) break;
                res += max+1;

//                System.out.println("res_left = "+left_right[idx][0]);
//                System.out.println("res right = "+left_right[idx][1]);
                for(int i=left_right[idx][0]; i<=left_right[idx][1]; i++){
                    visited[i] = true;
                }
//                System.out.println(Arrays.toString(visited));
            }










            System.out.println("Case #"+(test_case+1));
            System.out.println(res);
//            sb.append("Case #").append(test_case+1).append('\n').append(res).append('\n');
        }
//        System.out.println(sb);
    }
}