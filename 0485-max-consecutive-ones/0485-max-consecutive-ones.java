class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
                // Update maxCount whenever current streak grows
                maxCount = Math.max(maxCount, currentCount);
            } else {
                // Reset streak when hitting a 0
                currentCount = 0;
            }
        }

        return maxCount;
    }
}