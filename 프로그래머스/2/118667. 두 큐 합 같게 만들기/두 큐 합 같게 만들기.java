class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        int n = queue1.length;
        
        
        
        for(int i=0; i<n; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2)%2 == 1) return -1;
        long des = (sum2 - sum1)/2;
        
        boolean flag = false;
        int pointer1 = 0;
        int pointer2 = 0;
        long preSum1 = 0;
        long preSum2 = 0;
        int count = 0;
        while(pointer1 < 2*n && pointer2 < 2*n){
            long cur = preSum2 - preSum1;
            if(cur == des){
                flag = true;
                break;
            }
            else if(cur < des){
                if(pointer2<n) preSum2 += queue2[pointer2];
                else preSum2 += queue1[pointer2%n];
                pointer2++;
            }
            else{
                if(pointer1<n) preSum1 += queue1[pointer1];
                else preSum1 += queue2[pointer1%n];
                pointer1++;
            }
            // System.out.println("preSum1 = "+preSum1);
            // System.out.println("preSUm2 = "+preSum2);
            count++;
        }
        
        
        if(flag) return count;
        else return -1;
    }
}