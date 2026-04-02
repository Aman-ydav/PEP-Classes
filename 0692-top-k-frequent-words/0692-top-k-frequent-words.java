
class Solution {
    public class count1 {
        String s;
        int c;

        public count1(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<count1> pq = new PriorityQueue<>((a,b)->{
            if(a.c==b.c) return a.s.compareTo(b.s);
            return b.c-a.c;
        });
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(new count1(e.getKey(), e.getValue()));
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.remove().s);
        }

        return list;
    }
}