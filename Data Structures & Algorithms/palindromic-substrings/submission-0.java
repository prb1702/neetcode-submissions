class Solution {

    public int solve(int left, int right, String s){
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            count += solve(i, i+1, s);       // even length palindromes
            count += solve(i, i, s);       // odd length palindromes
        }

        return count;
    }
}
