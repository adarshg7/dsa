class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 0;
        int dec = 0;
        int tempi = 1;
        int tempd = 1;

        for(int i =0; i < nums.length - 1; i++){
            if(nums[i+1] > nums[i]){
                tempi++;
            }else{
                inc = Math.max(tempi,inc);
                tempi = 1;
            }

            if(nums[nums.length - i - 2] > nums[nums.length - i - 1]){
                tempd++;
            }else{
                dec = Math.max(dec,tempd);
                tempd = 1;
            }
        }

        inc = Math.max(inc,Math.max(tempi,Math.max(tempd,dec)));

        return inc;
    }
}
