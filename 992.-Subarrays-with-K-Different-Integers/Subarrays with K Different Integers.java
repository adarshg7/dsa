class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }

    public int atmost(int nums[], int k){
        int l = 0, r = 0, count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size() > k){
                map.put(nums[l],map.get(nums[l])-1);
                map.remove(nums[l],0);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
