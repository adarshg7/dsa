class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        List<List<Integer>> list = new ArrayList<>();
        int subsets = 1 << nums.length;
        for(int i = 0; i<subsets; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j< nums.length; j++){
                if(( i & (1 << j)) != 0){
                    l.add(nums[j]);
                }
            }
            set.add(l);
        }

        for(List<Integer> l : set){
            list.add(l);
        }
        return list;
    }
}

//or

