class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(s.charAt(i)=='#'){
                StringBuilder dup = sb;
                sb.append(dup);
            }
            else if(s.charAt(i)=='%'){
                sb.reverse();
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}