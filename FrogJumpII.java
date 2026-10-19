class Solution {
    public int maxJump(int[] stones) {

        if(stones.length == 2) return stones[1] - stones[0];

        int max1 = 0;
        for(int i = 3; i < stones.length; i += 2) {
            max1 = Math.max(max1, stones[i] - stones[i - 2]);
        }

        int max2 = 0;
        for(int i = 2; i < stones.length; i += 2) {
            max2 = Math.max(max2, stones[i] - stones[i - 2]);
        }

        return Math.max(max1, max2);
    }
}

// or 

class Solution {
    public int maxJump(int[] stones) {
        int mxj = stones[1]-stones[0];
        for(int i =2; i<stones.length; i++){
            mxj = Math.max(mxj,stones[i]-stones[i-2]);
        }
        return mxj;
    }
}
