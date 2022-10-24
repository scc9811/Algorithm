import java.util.Scanner;
/*
배열크기 50으로 하나 만들고
여는괄호 나오면 맨 앞에 push,
닫는괄호 나오면 배열 0번째 꺼내서 여는괄호인지 확인.

 */
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int j=0; j<n; j++) {
            int count = 0;
            char[] cArray = new char[50];
            String S = input.next();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    cArray[count] = '(';
                    count++;
                } else if (S.charAt(i) == ')') {
                    if (count == 0) {
                        System.out.println("NO");
                        break;
                    } else {
                        count--;
                    }
                }
                if (i == S.length() - 1){
                    if (count==0){
                        System.out.println("YES");
                    }
                    else System.out.println("NO");

                }
            }
        }







    }


}
