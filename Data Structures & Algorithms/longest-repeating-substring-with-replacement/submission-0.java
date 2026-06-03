class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));
            if(i - left + 1 - maxFreq > k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
