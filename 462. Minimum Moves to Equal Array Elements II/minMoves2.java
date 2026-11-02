class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int med;
        if( n % 2 == 0){
            med = (nums[n/2] + nums[n/2 -1]) / 2;
        }else {
            med = nums[n/2];
        }

        for(int num : nums){
            ans += Math.abs(num - med);
        }
        return ans;
    }
}
