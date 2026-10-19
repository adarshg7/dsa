class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(list,0,target,0,candidates,l);
        return list;
        
    }

    public void f(List<List<Integer>> list, int sum , int target, int i, int nums[], List<Integer> l){
        if( sum == target){
            list.add(new ArrayList<>(l));
            return;
        }
        if(i == nums.length || sum > target){
            
                return;
            
        }
        

        l.add(nums[i]);
        f(list,sum + nums[i], target, i , nums, l);
        l.remove(l.size()-1);
        f(list,sum,target,i+1,nums,l);

    }
}

//Or
