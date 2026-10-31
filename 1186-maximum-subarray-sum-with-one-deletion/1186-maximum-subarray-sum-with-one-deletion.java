class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDelete = arr[0];
        int oneDelete = 0;
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            oneDelete = Math.max(noDelete, oneDelete + arr[i]);
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            result = Math.max(result, Math.max(noDelete, oneDelete));
        }

        return result;
    }
}