import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> getNameNumber = new HashMap<>();
        int n = friends.length;
        for(int i=0; i<n; i++){
            getNameNumber.put(friends[i], i);
        }
        int[][] arr = new int[n][n];
        int[] totalPointArr = new int[n];
        for(int i=0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int p1 = getNameNumber.get(st.nextToken());
            int p2 = getNameNumber.get(st.nextToken());
            arr[p1][p2]++;
            totalPointArr[p1]++;
            totalPointArr[p2]--;
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(arr[i][j] == arr[j][i]){
                    if(totalPointArr[i] > totalPointArr[j]){
                        res[i]++;
                    }
                }
                else if(arr[i][j] > arr[j][i]){
                    res[i]++;
                }

            }
        }


        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, res[i]);
        }
        return max;



    }
}