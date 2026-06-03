class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str: strs){
            encode.append(str.length()).append("#").append(str);
        }

        return encode.toString();
    }
    // 5#Hello5#World

    public List<String> decode(String str) {
        int i = 0;

        List<String> result = new ArrayList<>();
        
        while(i < str.length()){
            
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String s = str.substring(j + 1, j + 1 + length);

            result.add(s);

            i = j + 1 + length;
        }

        return result;
    }
}
