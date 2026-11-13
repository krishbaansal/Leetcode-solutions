class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int x : nums){
            max=Math.max(max,x);
        }
        int num=0;
        for(int i : nums){
            num+=(max-i);
        }
        return num;
    }
}