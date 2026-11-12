class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inc = 1,  dec = 1;
        int maxlen=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                inc+=1;
                dec=1;
            }else if(nums[i]<nums[i-1]){
                inc=1;
                dec+=1;
            }else{
                inc=1;
                dec=1;
            }
            maxlen = Math.max(maxlen,Math.max(inc,dec));
        }
        return maxlen;
    }
}