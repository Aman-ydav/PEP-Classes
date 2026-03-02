class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for (char c : freq.keySet()) {
            int f = freq.get(c);

            if (bucket[f] == null)
                bucket[f] = new ArrayList<>();

            bucket[f].add(c);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int k = 0; k < i; k++) {
                        ans.append(c);
                    }
                }
            }
        }

        return ans.toString();
    }
}