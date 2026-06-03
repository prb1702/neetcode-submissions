class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
       
        for(int i = 0; i < n - 1; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = i + 1; j < n; j++){
                int target = 0-(nums[i] + nums[j]);
                if(list.contains(target)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(temp);
                    result.add(temp);
                }
                list.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}
