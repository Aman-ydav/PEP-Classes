class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int left = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while ((right - left + 1) > map.size()) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
