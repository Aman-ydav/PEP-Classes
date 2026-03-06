class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count =0;
        int l=0;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            sb.append(c);
            if(i-l+1>k){
                sb.deleteCharAt(0);
                l++;
            }
            if(i-l+1==k){
                set.add(sb.toString());
            }

        }
        if(set.size()>=Math.pow(2,k)) return true;
        return false;
    }
}