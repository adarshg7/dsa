class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftm = 0;
        int rightm = 0;
        int water = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftm){
                    leftm = height[left];
                }else{
                    water += leftm - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightm){
                    rightm = height[right];
                }else{
                    water += rightm - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
