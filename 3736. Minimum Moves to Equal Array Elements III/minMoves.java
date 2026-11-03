class Solution {
    public int minMoves(int[] nums) {
        if(nums.length <= 1) return 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }

        int ans = 0;

        for(int i =0; i< nums.length; i++){
            ans += max - nums[i];
        }

        return ans;
    }
}
