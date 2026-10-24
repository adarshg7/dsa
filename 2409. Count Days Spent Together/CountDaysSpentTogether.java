class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.parseInt(arriveAlice.substring(0,2));
        int aad = Integer.parseInt(arriveAlice.substring(3));

        int alm = Integer.parseInt(leaveAlice.substring(0,2));
        int ald = Integer.parseInt(leaveAlice.substring(3));

        int bam = Integer.parseInt(arriveBob.substring(0,2));
        int bad = Integer.parseInt(arriveBob.substring(3));

        int blm = Integer.parseInt(leaveBob.substring(0,2));
        int bld = Integer.parseInt(leaveBob.substring(3));

        int pre[] = {0,31,59,90,120,151,181,212,243,273,304,334,365};
        
        int a = pre[aam - 1] + aad;
        int a2 = pre[alm - 1] + ald;

        int b = pre[bam - 1] + bad;
        int b2 = pre[blm -1] + bld;

        if( a2 < b) return 0;

        int ans = 0;

        for(int i = Math.max(b,a); i <= Math.min(a2,b2); i++){
            ans++;
        }
        return ans;
    }
}
