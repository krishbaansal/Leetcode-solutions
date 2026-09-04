class Solution {
    public int maximumCandies(int[] candies, long k) {

        long total = 0;
        int max = 0;

        for (int candy : candies) {
            total += candy;
            max = Math.max(max, candy);
        }

        if (total < k) {
            return 0;
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long children = 0;

            for (int candy : candies) {
                children += candy / mid;
            }

            if (children >= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}