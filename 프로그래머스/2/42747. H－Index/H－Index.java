import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int max = 0;
        int n = citations.length;
        
        for(int h = 0; h<=10000; h++){
            System.out.println("h = "+h);
            int count = 0;
            for(int i=0; i<n; i++){
                if(citations[i] >= h){
                    count++;
                }
                
            if(count >= h) max = Math.max(max, h);
        }
        }
        
        
        
        return max;
    }
}