class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int res = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 1){
                ans++;
            }else{
                res = Math.max(ans,res);
                ans = 0;
            }
        }
         return Math.max(res,ans);
    }
}
