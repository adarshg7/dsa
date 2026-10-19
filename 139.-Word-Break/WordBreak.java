class Solution {

    class Node{
        Node children[] = new Node[26];
        boolean eow = false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();

        for(String word : wordDict){
            Node curr = root;

            for(char c : word.toCharArray()){
                int idx = c -'a';

                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.eow = true;
        }

        int n = s.length();

        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        for(int i =0; i< n; i++){
            if(!dp[i]){
                continue;
            }

            Node curr = root;

            for(int j = i; j<n; j++){
                int idx = s.charAt(j) - 'a';

                if(curr.children[idx] == null){
                    break;
                }

                curr = curr.children[idx];

                if(curr.eow){
                    dp[j+1] =  true; 
                }
            }
        }
        return dp[n];
    }
}

//or


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int len = 1; len <= 20 && len <= i; len++) {

                if (dp[i - len] &&
                    set.contains(s.substring(i - len, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
