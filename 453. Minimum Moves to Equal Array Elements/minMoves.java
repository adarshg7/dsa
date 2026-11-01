class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int i =1; i< nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            } 

            if(nums[i] < min){
                min = nums[i];
            }
        }

        if(min == max) return 0;

        int ans = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] != min){
                ans += (nums[i] - min);
            }
        }

        return ans;
    }
}
