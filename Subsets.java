class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsets = 1 << nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i<subsets; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j< nums.length; j++){
                if( (i & (1 << j)) != 0){
                    l.add(nums[j]);
                }
            }
            list.add(l);
        }
        return list;
    }
}

//Or

class Solution {
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(nums, 0, l,list);
        return list;
    }
    public void f(int nums[], int i, List<Integer> l, List<List<Integer>> list){
        if( i == nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        f(nums, i + 1, l,list);
        l.remove(l.size()-1);
        f(nums, i + 1, l,list);
    }
}

//
