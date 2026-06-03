class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        int n = nums.length;

        int[] result = new int[n - k + 1];
        int ind = 0;

        for(int i = 0; i < nums.length; i++){

            if(!deq.isEmpty() && deq.peekFirst() <= i - k){
                deq.pollFirst();
            }
            
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]){
                deq.pollLast();
            }

            deq.offerLast(i);

            if(i >= k - 1){
                result[ind++] = nums[deq.peekFirst()];
            }

        }

        return result;
    }
}
