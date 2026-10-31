class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int count : freq) {
            if (count > 0) {
                pq.offer(count);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {
                int count = pq.poll();

                if (count > 1) {
                    temp.add(count - 1);
                }

                time++;
                cycle--;
            }

            for (int count : temp) {
                pq.offer(count);
            }

            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}