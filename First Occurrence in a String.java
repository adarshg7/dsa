class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

//or
class Solution {

    private int[] buildLPS(String needle){
        int lps[] = new int[needle.length()];

        int len = 0; 
        int i = 1;

        while( i < needle.length()){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len > 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);

        int i =0; 
        int j = 0;
        while( i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if( j == needle.length()){
                    return i - j;
                }
            }else{
                if( j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
}

//or

class Solution {
    public int strStr(String haystack, String needle) {
        for(int i =0; i< haystack.length(); i++){
            int j = 0;
            int k = i;
    
            while(k < haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j)){
                

                if(k < haystack.length()  &&  j == needle.length()-1 && haystack.charAt(k) == needle.charAt(j)){
                    return i;
                }

                k++;
                j++;
            }
        }
        return -1;
    }
}
