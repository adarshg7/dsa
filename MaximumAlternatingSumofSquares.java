class Solution {
    public long maxAlternatingSum(int[] nums) {
        int mod = 1000000007;
        for(int i =0; i< nums.length; i++){
            if(nums[i] < 0) nums[i] = -nums[i];
        }
        Arrays.sort(nums);

        int i =0; 
        int j = nums.length - 1;
        long sum = 0;
        while( i < j){
            long pick = nums[j]*nums[j];
            long np = nums[i]*nums[i];

            sum += pick - np;
            i++;
            j--;
        }

        if( nums.length % 2 != 0){
            sum += nums[nums.length / 2]*nums[nums.length / 2];
        }

        return sum;
    }
}
