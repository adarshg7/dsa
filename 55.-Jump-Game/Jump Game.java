class Solution {
    public boolean canJump(int[] nums) {
        int a = 0;
        for(int i =0; i<nums.length; i++){
            if(a < i) return false;
            a = Math.max(a,nums[i] + i);
        }

        return true;
    }
}
