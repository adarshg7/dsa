class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1 + "");
        for(int i = 2; i <= n; i++){
           sb = abc(sb);
        }
        return sb.toString();
    }

    public StringBuilder abc(StringBuilder sb){
        int count = 1;
        char prev= sb.charAt(0);
        int n = sb.length();
        StringBuilder sb2 = new StringBuilder();
        for(int i =1; i< n; i++){
            if(prev == sb.charAt(i)){
                count++;
            }else{
                sb2.append(count + "");
                sb2.append(prev);
                count = 1;
                prev = sb.charAt(i);
            }
        }
        sb2.append(count + "");
        sb2.append(prev);

        return sb2;
    }
}
