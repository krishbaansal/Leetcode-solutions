import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = new int[intervals.length][2];
        int index = 0;

        result[index++] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result[index - 1][1]) {
                result[index - 1][1] = Math.max(
                    result[index - 1][1], intervals[i][1]
                );
            } else {
                result[index++] = intervals[i];
            }
        }

        return Arrays.copyOf(result, index);
    }
}