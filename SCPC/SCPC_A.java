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
class Solution22 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Point point = new Point(0, 0);


            long resCount = 0;
            // 0 : i, 1 : count
            long[][] store = new long[100][2];


            boolean flag = true;
            for(int i=1; i<=k; i++){
                for(int j=0; j<n; j++){
                    int step = arr[j];

                    point.idx += arr[j];
                    if(point.boardNum == 0){
                        if(point.idx == 5){
                            point.boardNum = 5;
                            point.idx = 0;
                        }
                        else {
                            point.boardNum = 1;
                        }
                    }

                    else if(point.boardNum == 1){
                        if(point.idx == 5){
                            point.boardNum = 5;
                            point.idx = 0;
                        }
                        else if(point.idx >= 6){
                            point.boardNum = 2;
                            point.idx -= 5;
                        }
                    }

                    else if(point.boardNum == 2){
                        if(point.idx == 5){
                            point.boardNum = 6;
                            point.idx = 0;
                        }
                        else if(point.idx >= 6){
                            point.boardNum = 3;
                            point.idx -= 5;
                        }
                    }

                    else if(point.boardNum == 3){
                        if(point.idx >= 5){
                            point.boardNum =4;
                            point.idx -= 5;
                        }
                    }

                    else if(point.boardNum == 4){
                        if(point.idx >= 6){
                            resCount++;
                            point.boardNum = 0;
                            point.idx = 0;
                        }
                    }

                    else if(point.boardNum == 5){
                        if(point.idx == 3){
                            point.boardNum = 8;
                            point.idx = 0;
                        }
                        else if(point.idx == 4 || point.idx == 5){
                            point.boardNum = 7;
                            point.idx -= 3;
                        }
                        else if(point.idx >= 6){
                            point.boardNum = 4;
                            point.idx -= 6;
                        }
                    }

                    else if(point.boardNum == 6){
                        if(point.idx >= 7){
                            resCount++;
                            point.boardNum = 0;
                            point.idx = 0;
                        }
                        else if(point.idx >= 3){
                            point.boardNum = 8;
                            point.idx -= 3;
                        }
                    }

                    else if(point.boardNum == 7){
                        if(point.idx >= 3){
                            point.boardNum = 4;
                            point.idx -= 3;
                        }
                    }

                    else if(point.boardNum == 8){
                        if(point.idx >= 4){
                            resCount++;
                            point.boardNum = 0;
                            point.idx = 0;
                        }
                    }

                }
                if(flag) {
                    int cur = point.boardNum * 10 + point.idx;
                    if (store[cur][0] != 0) {
                        long step = i - store[cur][0];
                        long plus = resCount - store[cur][1];
                        while (i < k) {
                            i += step;
                            resCount += plus;
                        }
                        i -= step;
                        resCount -= plus;
                        flag = false;
                    }
                    else{
                        store[cur][0] = i;
                        store[cur][1] = resCount;
                    }
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
//            System.out.println(resCount);
            sb.append("Case #").append(test_case+1).append('\n').append(resCount).append('\n');
        }
        System.out.println(sb);
    }
    static class Point{
        int boardNum, idx;
        Point(int boardNum, int idx){
            this.boardNum = boardNum;
            this.idx = idx;
        }
    }
}