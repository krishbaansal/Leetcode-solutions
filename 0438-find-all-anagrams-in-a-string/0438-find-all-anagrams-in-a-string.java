

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) return ans;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Count characters in p
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int k = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add current character
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Remove character outside the window
            if (i >= k) {
                char remove = s.charAt(i - k);

                if (window.get(remove) == 1) {
                    window.remove(remove);
                } else {
                    window.put(remove, window.get(remove) - 1);
                }
            }

            // Compare current window with p
            if (window.equals(pMap)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }
}