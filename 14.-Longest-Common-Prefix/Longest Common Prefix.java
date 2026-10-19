class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int n = Math.min(strs[0].length(), strs[1].length());
        for (int j = 0; j < n; j++) {
            if (strs[0].charAt(j) == strs[1].charAt(j)) {
                sb.append(strs[0].charAt(j));
            } else {
                break;
            }
        }
        for (int i = 2; i < strs.length; i++) {
            int j = 0;
            while (j < sb.length()
                    && j < strs[i].length()
                    && sb.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            sb.setLength(j);
            if (sb.length() == 0) {
                return "";
            }
        }
        return sb.toString();
    }
}

//or

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0 ){
            return "";
        }
        String pref = strs[0];
        int preflen = pref.length();

        for(int i = 1; i<strs.length; i++){
            String s = strs[i];
            while( s.length() < preflen || !pref.equals(s.substring(0,preflen))){
                preflen--;
                if(preflen ==0){
                    return "";
                }
                pref = pref.substring(0,preflen);
            }
        }
        return pref;

    }
}
