class Solution {
    public String reverseOnlyLetters(String s) {
        int i =0;
        int j = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(i<j){
            
            while(i<j && !(sb.charAt(i)>=65 && sb.charAt(i)<=90) && !(sb.charAt(i)>=97 && sb.charAt(i)<=122) ){
                i++;
            }
            while(j>i && !(sb.charAt(j)>=65 && sb.charAt(j)<=90) && !(sb.charAt(j)>=97 && sb.charAt(j)<=122) ) {
                j--;
            }
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            j--;
            i++;
        }
        return sb.toString();
    }
}