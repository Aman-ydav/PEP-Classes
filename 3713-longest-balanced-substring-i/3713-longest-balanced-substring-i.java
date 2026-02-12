class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen = 0;
        for(int i=0;i<n;i++){
           HashMap<Character,Integer> map = new HashMap<>();

           for(int j=i;j<n;j++){
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(isBalanced(map))
                maxlen = Math.max(maxlen,j-i+1);
           }
        }
        return maxlen;
    }
    boolean isBalanced(HashMap<Character,Integer> map){
        int c =0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(c==0){
                    c = entry.getValue();
                }
                else if(entry.getValue()!=c){
                    return false;
                }
            }
            return true;
    }
}