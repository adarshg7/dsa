class Solution {
     public int repeatedStringMatch(String A, String B) {

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < B.length()) {
        sb.append(A);
        count++;
    }
    if(search(sb.toString(),B)) return count;
    if(search(sb.append(A).toString(),B)) return ++count;
    return -1;
}

private boolean search(String text, String pattern){
    int n = text.length();
    int m = pattern.length();

    if(m > n){
        return false;
    }

    long base = 31;
    long mod = 1000000007;

    long ph = 0;
    long th = 0;
    long hp = 1;

    for(int i = 0; i< m- 1; i++){
        hp = (hp*base) % mod;
    }

    for(int i =0; i<m ; i++){
        ph = (ph * base + pattern.charAt(i)) % mod;
        th = (th*base + text.charAt(i)) % mod;
    }

    for(int i =0; i<= n-m; i++){
        if(ph == th){
            if(text.substring(i,i+m).equals(pattern)){
                return true;
            }
        }

        if( i < n- m){
            th = (th - text.charAt(i)*hp % mod + mod) % mod;
            th = (th * base + text.charAt(i+m)) % mod;
        }
    }
    return false;
}
}

//or

class Solution {
     public int repeatedStringMatch(String A, String B) {

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < B.length()) {
        sb.append(A);
        count++;
    }
    if(sb.toString().contains(B)) return count;
    if(sb.append(A).toString().contains(B)) return ++count;
    return -1;
}
}
