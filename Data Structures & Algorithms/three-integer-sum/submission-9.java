class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>(); 

        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) j++;
                else if(sum > 0) k--;
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(temp);
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--; 
                }
            }
        }

        return result;


        // Set<List<Integer>> result = new HashSet<>();
       
        // for(int i = 0; i < n - 1; i++){
        //     Set<Integer> list = new HashSet<>();
        //     for(int j = i + 1; j < n; j++){
        //         int target = 0-(nums[i] + nums[j]);
        //         if(list.contains(target)){
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], target);
        //             Collections.sort(temp);
        //             result.add(temp);
        //         }
        //         list.add(nums[j]);
        //     }
        // }

        // return new ArrayList<>(result);
    }
}
