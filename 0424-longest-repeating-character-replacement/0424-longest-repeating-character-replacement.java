class Solution {
    public int characterReplacement(String s, int k) {
        int low=0;
        int high=0;
        int maxcount=0;
        int res=0;
        int[] arr = new int[256];
        for(high=0;high<s.length();high++){
            char ch = s.charAt(high);
            arr[ch]++;
            int len=high-low+1;
            maxcount=Math.max(maxcount,arr[ch]);
            int diff= len-maxcount;
            while(diff>k){
                ch= s.charAt(low);
                arr[ch]--;
                low++;
                len=high-low+1;
                maxcount=Math.max(maxcount,arr[ch]);
                diff=len-maxcount;
            }
            res=Math.max(res,len);

        }
        return res;
    }
}