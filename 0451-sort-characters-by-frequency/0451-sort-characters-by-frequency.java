class Solution {
    public String frequencySort(String s) {
        TreeMap<Character,Integer> map=new TreeMap<>();
       for(int i=0;i<s.length();i++){
           map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
       }
       
       List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
       list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
       
       StringBuilder sb = new StringBuilder("");
       
       for (Map.Entry<Character, Integer> entry : list) {
            int i =1;
            while(i<=entry.getValue()){
                sb.append(entry.getKey());
                i++;
            }
        }
        return sb.toString();
    }
}