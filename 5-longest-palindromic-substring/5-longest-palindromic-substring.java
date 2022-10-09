class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int st = 0;int end = 0;
        for(int i=0;i<n;i++) {
            int len1 = expand(s,i,i+1);
            int len2 = expand(s,i,i);
            int len = Math.max(len1,len2);
            if(end - st < len) {
                st = i- (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(st, end+1);
    }
    
    public int expand(String s, int i, int j){
        while(i>=0 && j<=s.length()-1 && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }
        return j-i-1;
    }
}