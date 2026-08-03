class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int low = 0;
       int high = 0;
       int sum = 0;
       int ans = Integer.MAX_VALUE;
       while(high<nums.length){
        sum+=nums[high];
        while(sum>=target){
            ans= Math.min(ans,high-low+1);
            sum -= nums[low];
            low++;
        }
        high++;
       }
       if(ans==Integer.MAX_VALUE){
        return 0;
        }
       else{
        return ans;
      }

    }
}