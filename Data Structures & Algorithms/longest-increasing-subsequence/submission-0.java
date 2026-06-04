class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        for(int num : nums){
            int left = 0;
            int right = temp.size();

            while(left < right){
                int mid = (left + right)/2;

                if(temp.get(mid) < num) left = mid + 1;
                else right = mid;
            }

            if(left == temp.size()) temp.add(num);
            else temp.set(left, num);
        }

        return temp.size();
    }
}
