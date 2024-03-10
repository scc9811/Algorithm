import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        long day1 = (y1-1)*365 + d1;
        long day2 = (y2-1)*365 + d2;
        Set<Integer> set30 = new LinkedHashSet<>();
        set30.add(4);
        set30.add(6);
        set30.add(9);
        set30.add(11);



        for(int month=1; month<m1; month++){
            if(month==2){
                if((y1%100!=0 && y1%4==0) || y1%400==0){
                    day1 += 29;
                }
                else day1 += 28;
            }
            else if(set30.contains(month)) day1 += 30;
            else day1 += 31;
        }

        for(int i=1000; i<y1; i+=4){
            day1++;
            if(i%100==0 && i%400!=0){
                day1--;
            }
        }

        for(int month=1; month<m2; month++){
            if(month==2){
                if((y2%100!=0 && y2%4==0) || y2%400==0){
                    day2 += 29;
                }
                else day2 += 28;
            }
            else if(set30.contains(month)) day2 += 30;
            else day2 += 31;
        }

        for(int i=1000; i<y2; i+=4){
            day2++;
            if(i%100==0 && i%400!=0){
                day2--;
            }
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Node[] arr= new Node[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(flag==3) v *= 30;
            arr[i] = new Node(c, v);
        }

//        for(int i=1; i<=n; i++){
//            System.out.printf("(%d, %d)\n", arr[i].cost, arr[i].value);
//        }
        int[][] dp = new int[n+1][t+1];


        for(int i=1; i<=n; i++){
            dp[i] = Arrays.copyOf(dp[i-1], t+1);
            int cost = arr[i].cost;
            for(int j=cost; j<=t; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost] + arr[i].value);
            }
        }

        int max = 0;
        for(int j=0; j<=t; j++){
            max = Math.max(max, dp[n][j]);
        }
        System.out.println(Math.abs(day2 - day1 - max));











    }
    static class Node{
        int cost, value;
        Node(int cost, int value){
            this.cost = cost;
            this.value = value;
        }
    }
}