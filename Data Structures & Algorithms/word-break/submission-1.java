class Solution {

    public boolean solve(int ind, String s, Set<String> set, Boolean[] dp, int maxLen){

        if(ind == s.length()) return true;

        if(dp[ind] != null) return dp[ind];

        for(int i = 1; i <= maxLen && ind + i <= s.length(); i++){
            String temp = s.substring(ind, ind + i);
            
            if(set.contains(temp) && solve(ind + i, s, set, dp, maxLen)) return dp[ind] = true; 
        }

        return dp[ind] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[s.length()];

        int maxLen = 0;
        for(String word: wordDict){
            maxLen = Math.max(maxLen, word.length());
        }

        return solve(0, s, set, dp, maxLen);
    }
}
